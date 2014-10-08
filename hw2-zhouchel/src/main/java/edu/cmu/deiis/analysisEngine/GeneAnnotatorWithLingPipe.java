package edu.cmu.deiis.analysisEngine;

import edu.cmu.deiis.types.*;
import edu.cmu.deiis.resourceMap.StringMapResource;
import org.apache.uima.UimaContext;
import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.FSIterator;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.tcas.Annotation;
import org.apache.uima.resource.ResourceAccessException;
import org.apache.uima.resource.ResourceInitializationException;

import com.aliasi.chunk.Chunk;

/**
 * This annotator uses LingPipe toolkit to annotate all gene mentions.
 * 
 * @author zhouchel
 */
public class GeneAnnotatorWithLingPipe extends JCasAnnotator_ImplBase {
  /** Map from paramConfig */
  public static StringMapResource mMap;

  private LingPipeGeneNamedEntityRecognizer ner;

  @Override
  /**
   * Provides access to external resources (other than the CAS)<br>
   * Load parameters configuration from file paramConfig
   * 
   * @param aContext
   *          provides UIMA resources with all access to external resources (other than the CAS)
   *          
   * @see AnalysisComponent#initialize(UimaContext)
   */
  public void initialize(UimaContext aContext) throws ResourceInitializationException {
    super.initialize(aContext);
    this.ner = null;
    try {
      // get hashMap of all parameters set in paramConfig
      mMap = (StringMapResource) getContext().getResourceObject("paramConfig");

      // get the file name of selected model
      String model = mMap.get("model");

      String useNBest = mMap.get("N-Best_NER");
      if (useNBest.equalsIgnoreCase("true")) {
        // get parameter for MAX_N_BEST_CHUNKS
        int MAX_N_BEST_CHUNKS = Integer.parseInt(mMap.get("MAX_N_BEST_CHUNKS"));

        // get parameter for threshold
        double threshold = Double.parseDouble(mMap.get("LingPipeThreshold"));

        // initialize LingPipeGeneNamedEntityRecognizer, use ConfidenceChunker
        ner = new LingPipeGeneNamedEntityRecognizer(model, MAX_N_BEST_CHUNKS, threshold);
        //System.out.println("MAX_N_BEST_CHUNKS: " + MAX_N_BEST_CHUNKS);
        //System.out.println("Confidence Threshold: " + threshold);
      } else {
        // initialize LingPipeGeneNamedEntityRecognizer, use First-BestChunker
        ner = new LingPipeGeneNamedEntityRecognizer(model);
      }
    } catch (ResourceAccessException e) {
      // TODO Auto-generated catch block
      System.out.println("Failed to load Model");
      e.printStackTrace();
    }
  }

  /**
   * Use {@link edu.cmu.deiis.analysisEngine.LingPipeGeneNamedEntityRecognizer#chunk(String)} to
   * detect Gene names, then updated JCas
   * 
   * @param aJCas
   *          CAS containing TextTag annotation added in previous phrase, and to which GeneTag
   *          annotations are to be written.
   * 
   * @see org.apache.uima.analysis_component.JCasAnnotator_ImplBase#process(JCas)
   */
  public void process(JCas aJCas) throws AnalysisEngineProcessException {
    String id, text;
    int begin, end;
    String gene;

    FSIterator<Annotation> iter = aJCas.getAnnotationIndex(SentenceTag.type).iterator();
    while (iter.hasNext()) {

      SentenceTag annotation = (SentenceTag) iter.next();
      id = annotation.getId();
      text = annotation.getSentence();
      for (Chunk chunk : ner.chunk(text)) {
        begin = chunk.start();
        end = chunk.end();
        gene = text.substring(begin, end);

        GeneConfidence confidence = new GeneConfidence(aJCas);
        confidence.setBegin(begin); // set begin position
        confidence.setEnd(end); // set end position
        confidence.setId(id); // set sentence ID
        confidence.setGene(gene); // set gene name
        confidence.setSentence(text); // set original text
        confidence.setConfidence(Math.pow(2.0, chunk.score())); // set confidence
        confidence.setProcessedId(0); // set processed id to 0
        confidence.addToIndexes(); // add this FeatureStructure to Cas index
      }
    }
  }
}
