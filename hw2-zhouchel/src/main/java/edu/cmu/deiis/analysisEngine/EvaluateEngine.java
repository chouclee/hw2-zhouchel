package edu.cmu.deiis.analysisEngine;

import edu.cmu.deiis.types.*;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.FSIterator;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.tcas.Annotation;

import java.util.HashMap;
import java.util.HashSet;

/**
 * This annotator combines the results of LingPipe and Abner.
 * Total confidence of LingPipe and Abner are evaluated. Only those
 * that have a high confidence larger than threshold are tagged as gene names.
 * @author zhouchel
 */
public class EvaluateEngine extends JCasAnnotator_ImplBase {
  public void process(JCas aJCas) throws AnalysisEngineProcessException {
    String gene;
    GeneConfidence annotation;
    HashMap<String, Double> scoreMap = new HashMap<String, Double>();
    HashSet<String> providedByLingPipe = new HashSet<String>();
    HashSet<String> providedByAbner = new HashSet<String>();
    boolean isInScoreMap = false;

    FSIterator<Annotation> iter = aJCas.getAnnotationIndex(GeneConfidence.type).iterator();
    int processedId;
    while (iter.hasNext()) {
      annotation = (GeneConfidence) iter.next();
      processedId = annotation.getProcessedId();
      gene = annotation.getGene();
      isInScoreMap = scoreMap.containsKey(gene); // check if this gene name in score map
      if (processedId == 0){ // 0 --- LingPipe
        if (!isInScoreMap) {
          scoreMap.put(gene, annotation.getConfidence()); // put the gene score into map
          providedByLingPipe.add(gene); // mark that this gene has been counted 
        }
        else if (!providedByLingPipe.contains(gene)) { 
          // it's in the score map, it should be added by Abner
          // update the score
          scoreMap.put(gene, scoreMap.get(gene) + annotation.getConfidence());
          providedByLingPipe.add(gene);
        }
        else continue;
      } else {
        if (!isInScoreMap) {
          scoreMap.put(gene, annotation.getConfidence()); // put the gene score into map
          providedByAbner.add(gene); // mark that this gene has been counted 
        }
        else if (!providedByAbner.contains(gene)) { 
          // it's in the score map, it should be added by LingPipe
          // update the score
          scoreMap.put(gene, scoreMap.get(gene) + annotation.getConfidence());
          providedByAbner.add(gene);
        }
        else continue;
      }
    }
    
    iter = aJCas.getAnnotationIndex(GeneConfidence.type).iterator();
    double threshold = Double.parseDouble(
            GeneAnnotatorWithLingPipe.mMap.get("ConfidenceThreshold"));
    while (iter.hasNext()) {
      annotation = (GeneConfidence) iter.next();
      gene = annotation.getGene();
      if (scoreMap.get(gene) > threshold) { //there might be duplicated gene entries.
        GeneTag geneAnnotation = new GeneTag(aJCas);
        geneAnnotation.setBegin(annotation.getBegin());
        geneAnnotation.setEnd(annotation.getEnd());
        geneAnnotation.setId(annotation.getId());
        geneAnnotation.setGene(gene);
        geneAnnotation.setSentence(annotation.getSentence());
        geneAnnotation.addToIndexes();
      }
    }
  }
}

