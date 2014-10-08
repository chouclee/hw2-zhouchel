package edu.cmu.deiis.analysisEngine;

import edu.cmu.deiis.types.*;

import org.apache.uima.UimaContext;
import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.FSIterator;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.tcas.Annotation;
import org.apache.uima.resource.ResourceInitializationException;

/**
 * This annotator uses Abner to annotate all gene mentions.
 * 
 * @author zhouchel
 */
public class GeneAnnotatorWithAbner extends JCasAnnotator_ImplBase {
  private Abner ner;

  @Override
  public void initialize(UimaContext aContext) throws ResourceInitializationException {
    super.initialize(aContext);
    ner = new Abner();
  }

  /**
   * Use {@link edu.cmu.deiis.analysisEngine.Abner#chunk(String)}
   * to detect Gene names, then updated JCas
   * 
   * @param aJCas
   *          CAS containing TextTag annotation added in previous phrase, and to which GeneTag
   *          annotations are to be written.
   * 
   * @see org.apache.uima.analysis_component.JCasAnnotator_ImplBase#process(JCas)
   */  
  public void process(JCas aJCas) throws AnalysisEngineProcessException {
    String id, text;
    int begin, end = 0;

    FSIterator<Annotation> iter = aJCas.getAnnotationIndex(SentenceTag.type).iterator();
    while (iter.hasNext()) {

      SentenceTag annotationSen = (SentenceTag) iter.next();
      id = annotationSen.getId();
      text = annotationSen.getSentence();
      for (String chunk : ner.chunk(text)) {
        begin = text.indexOf(chunk, end); // find the first occurrence position of the gene
        if (begin == -1)
          continue;
        end = begin + chunk.length();
        
        GeneConfidence confidence = new GeneConfidence(aJCas);
        confidence.setBegin(begin);     // set begin position
        confidence.setEnd(end);         // set end position
        confidence.setId(id);           // set sentence ID
        confidence.setGene(chunk);      // set gene name
        confidence.setSentence(text);   // set original text
        confidence.setConfidence(1.0);  // set confidence to 1.0
        confidence.setProcessedId(1);   // set processed id to 1
        confidence.addToIndexes();      // add this FeatureStructure to Cas index
      }
    }
  }
}
