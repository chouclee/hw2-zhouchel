package edu.cmu.deiis.analysisEngine;

import edu.cmu.deiis.types.*;
import edu.cmu.deiis.util.CalcPreRecall;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;

import org.apache.uima.cas.CAS;
import org.apache.uima.cas.CASException;
import org.apache.uima.cas.FSIterator;
import org.apache.uima.collection.CasConsumer_ImplBase;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.tcas.Annotation;
import org.apache.uima.resource.ResourceProcessException;

/**
 * GeneTag CAS Consumer that writes all extracted Gene Mention results into a text.<br>
 * This CAS Consumer takes one parameter:
 * <ul>
 * <li><code>OutputFile</code> - path to which output file will be written</li>
 * </ul>
 * 
 * @author zhouchel
 * 
 */
public class GeneTagCasConsumer extends CasConsumer_ImplBase {

  /**
   * Name of configuration parameter that be set to the path of output file(optional)
   */
  public static final String PARAM_OUTPUT = "OutputFile";
  public static final String PARAM_GOLD = "GoldStand";

  private BufferedWriter writer;

  //private ClassLoader loader = GeneTagCasConsumer.class.getClassLoader();

  @Override
  /**
   * This method performs one-time startup logic, that is to say, opening output file,
   * which is called during initialization.
   * 
   * @see org.apache.uima.collection.CasConsumer_ImplBase#initialize()
   */
  public void initialize() {
    writer = null;
    String output = ((String) getConfigParameterValue(PARAM_OUTPUT)).trim();
    try {
      writer = new BufferedWriter(new FileWriter(output, false));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  /**
   * Processes the CasContainer which was populated by the TextAnalysisEngines.<br>
   * In this case, the Gene annotation was extracted first. Begin and end positions
   * were updated with calculated whitespace-excluded offsets. Sentence ID, gene name, 
   * begin and end positions were written into output file .
   * 
   * @param aCAS
   *          CasContainer which has been populated by the TAEs
   * 
   * @throws ResourceProcessException
   *           if there is an error in processing the Resource
   * 
   * @see org.apache.uima.collection.base_cpm.CasObjectProcessor#processCas(org.apache.uima.cas.CAS)
   */
  public void processCas(CAS aCas) throws ResourceProcessException {
    // TODO Auto-generated method stub
    JCas jcas;
    try {
      // You can create a JCas object from a CAS object by calling
      // the getJCas() method on the CAS object.
      jcas = aCas.getJCas();
    } catch (CASException e) {
      throw new ResourceProcessException(e);
    }
    String id, geneName, text;
    String entry;
    int begin, end;
    FSIterator<Annotation> iter = jcas.getAnnotationIndex(GeneTag.type).iterator();
    HashSet<String> hasBeenCounted = new HashSet<String>();
    while (iter.hasNext()) {
      GeneTag geneAnnotation = (GeneTag) iter.next();// get GeneTag annotation
      id = geneAnnotation.getId(); // get sentence ID
      geneName = geneAnnotation.getGene(); // get Gene name
      begin = geneAnnotation.getBegin(); // begin position of gene name
      text = geneAnnotation.getSentence(); // original sentence text
      // calculate whitespace-excluded offsets
      begin = begin - countWhiteSpaces(text.substring(0, begin));
      end = begin + geneName.length() - countWhiteSpaces(geneName) - 1;
      entry = id + "|" + begin + " " + end + "|" + geneName + "\n";
      if (!hasBeenCounted.contains(entry)) {
        hasBeenCounted.add(entry);
        try {
          writer.write(entry);
        } catch (IOException e) {
          throw new ResourceProcessException(e);
        }
      }
    }
  }

  @Override
  /**
   * Releases all resources and calculates predicted precision and recall
   * 
   * @see org.apache.uima.collection.CasConsumer_ImplBase#destory()
   */
  public void destroy() {
    try {
      writer.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    if (GeneAnnotatorWithLingPipe.mMap.get("Evaluation").equalsIgnoreCase("true")) {
      String standard;
      try {
        standard = ((String) getConfigParameterValue(PARAM_GOLD)).trim();
        //standard = GeneAnnotatorWithLingPipe.mMap.get("Gold_Standard");
        if (standard == null)
          throw new ResourceProcessException();
          
        // Evaluate the final results. Calculate precision and recall
        
        CalcPreRecall statistic = new CalcPreRecall(standard,
                ((String) getConfigParameterValue(PARAM_OUTPUT)).trim());
        System.out.println("Precision: " + statistic.precision());
        System.out.println("Recall: " + statistic.recall());
        System.out.println("F1 score: " + statistic.f1score());
        
      } catch (ResourceProcessException e) {
        e.printStackTrace();
      }
    }
  }

  /*************
   * Helper Function************ Count white spaces in a string return the count number
   ****************************************/
  private int countWhiteSpaces(String str) {
    int cnt = 0;
    for (int i = 0; i < str.length(); i++) {
      if (str.charAt(i) == ' ')
        cnt++;
    }
    return cnt;
  }
}