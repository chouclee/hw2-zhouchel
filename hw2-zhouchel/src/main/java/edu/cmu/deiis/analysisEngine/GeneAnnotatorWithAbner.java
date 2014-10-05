package edu.cmu.deiis.analysisEngine;

import edu.cmu.deiis.types.*;
import org.apache.uima.UimaContext;
import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.FSIterator;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.tcas.Annotation;
import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.util.Level;

import java.util.HashMap;

public class GeneAnnotatorWithAbner extends JCasAnnotator_ImplBase {
  private Abner ner;
  @Override
  public void initialize(UimaContext aContext) throws ResourceInitializationException {
    //String model = ((String)aContext.getConfigParameterValue(PARAM_MODEL)).trim();
   super.initialize(aContext);
   ner = new Abner();
  }
  public void process(JCas aJCas) throws AnalysisEngineProcessException {
    String id, text;
    int begin, end = 0;
    String gene;

    FSIterator<Annotation> iter = aJCas.getAnnotationIndex(SentenceTag.type).iterator();
    while (iter.hasNext()) {

      SentenceTag annotation = (SentenceTag) iter.next();
      id = annotation.getId();
      text = annotation.getSentence();
      for (String chunk : ner.chunk(text)) {
        begin = text.indexOf(chunk, end);
        if (begin == -1)
          continue;
        end = begin + chunk.length();
        //gene = text.substring(begin, end);
        
        GeneTag geneAnnotation = new GeneTag(aJCas);
        geneAnnotation.setBegin(begin);
        geneAnnotation.setEnd(end);
        geneAnnotation.setId(id);
        geneAnnotation.setGene(chunk);
        geneAnnotation.setSentence(text);
        geneAnnotation.addToIndexes();
        //getContext().getLogger().log(Level.FINEST, "Found: " + annotation);
      }
    }
  }
}
