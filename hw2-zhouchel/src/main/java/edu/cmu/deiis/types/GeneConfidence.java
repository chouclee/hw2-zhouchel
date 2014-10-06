

/* First created by JCasGen Sun Oct 05 20:12:56 EDT 2014 */
package edu.cmu.deiis.types;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;


/** 
 * Updated by JCasGen Sun Oct 05 20:57:50 EDT 2014
 * XML source: /home/happyuser/git/hw2-zhouchel/hw2-zhouchel/src/main/resources/descriptors/deiis_types.xml
 * @generated */
public class GeneConfidence extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(GeneConfidence.class);
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int type = typeIndexID;
  /** @generated  */
  @Override
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected GeneConfidence() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public GeneConfidence(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public GeneConfidence(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public GeneConfidence(JCas jcas, int begin, int end) {
    super(jcas);
    setBegin(begin);
    setEnd(end);
    readObject();
  }   

  /** <!-- begin-user-doc -->
    * Write your own initialization here
    * <!-- end-user-doc -->
  @generated modifiable */
  private void readObject() {/*default - does nothing empty block */}
     
 
    
  //*--------------*
  //* Feature: id

  /** getter for id - gets 
   * @generated */
  public String getId() {
    if (GeneConfidence_Type.featOkTst && ((GeneConfidence_Type)jcasType).casFeat_id == null)
      jcasType.jcas.throwFeatMissing("id", "edu.cmu.deiis.types.GeneConfidence");
    return jcasType.ll_cas.ll_getStringValue(addr, ((GeneConfidence_Type)jcasType).casFeatCode_id);}
    
  /** setter for id - sets  
   * @generated */
  public void setId(String v) {
    if (GeneConfidence_Type.featOkTst && ((GeneConfidence_Type)jcasType).casFeat_id == null)
      jcasType.jcas.throwFeatMissing("id", "edu.cmu.deiis.types.GeneConfidence");
    jcasType.ll_cas.ll_setStringValue(addr, ((GeneConfidence_Type)jcasType).casFeatCode_id, v);}    
   
    
  //*--------------*
  //* Feature: gene

  /** getter for gene - gets 
   * @generated */
  public String getGene() {
    if (GeneConfidence_Type.featOkTst && ((GeneConfidence_Type)jcasType).casFeat_gene == null)
      jcasType.jcas.throwFeatMissing("gene", "edu.cmu.deiis.types.GeneConfidence");
    return jcasType.ll_cas.ll_getStringValue(addr, ((GeneConfidence_Type)jcasType).casFeatCode_gene);}
    
  /** setter for gene - sets  
   * @generated */
  public void setGene(String v) {
    if (GeneConfidence_Type.featOkTst && ((GeneConfidence_Type)jcasType).casFeat_gene == null)
      jcasType.jcas.throwFeatMissing("gene", "edu.cmu.deiis.types.GeneConfidence");
    jcasType.ll_cas.ll_setStringValue(addr, ((GeneConfidence_Type)jcasType).casFeatCode_gene, v);}    
   
    
  //*--------------*
  //* Feature: sentence

  /** getter for sentence - gets 
   * @generated */
  public String getSentence() {
    if (GeneConfidence_Type.featOkTst && ((GeneConfidence_Type)jcasType).casFeat_sentence == null)
      jcasType.jcas.throwFeatMissing("sentence", "edu.cmu.deiis.types.GeneConfidence");
    return jcasType.ll_cas.ll_getStringValue(addr, ((GeneConfidence_Type)jcasType).casFeatCode_sentence);}
    
  /** setter for sentence - sets  
   * @generated */
  public void setSentence(String v) {
    if (GeneConfidence_Type.featOkTst && ((GeneConfidence_Type)jcasType).casFeat_sentence == null)
      jcasType.jcas.throwFeatMissing("sentence", "edu.cmu.deiis.types.GeneConfidence");
    jcasType.ll_cas.ll_setStringValue(addr, ((GeneConfidence_Type)jcasType).casFeatCode_sentence, v);}    
   
    
  //*--------------*
  //* Feature: processedId

  /** getter for processedId - gets 
   * @generated */
  public int getProcessedId() {
    if (GeneConfidence_Type.featOkTst && ((GeneConfidence_Type)jcasType).casFeat_processedId == null)
      jcasType.jcas.throwFeatMissing("processedId", "edu.cmu.deiis.types.GeneConfidence");
    return jcasType.ll_cas.ll_getIntValue(addr, ((GeneConfidence_Type)jcasType).casFeatCode_processedId);}
    
  /** setter for processedId - sets  
   * @generated */
  public void setProcessedId(int v) {
    if (GeneConfidence_Type.featOkTst && ((GeneConfidence_Type)jcasType).casFeat_processedId == null)
      jcasType.jcas.throwFeatMissing("processedId", "edu.cmu.deiis.types.GeneConfidence");
    jcasType.ll_cas.ll_setIntValue(addr, ((GeneConfidence_Type)jcasType).casFeatCode_processedId, v);}    
   
    
  //*--------------*
  //* Feature: confidence

  /** getter for confidence - gets 
   * @generated */
  public double getConfidence() {
    if (GeneConfidence_Type.featOkTst && ((GeneConfidence_Type)jcasType).casFeat_confidence == null)
      jcasType.jcas.throwFeatMissing("confidence", "edu.cmu.deiis.types.GeneConfidence");
    return jcasType.ll_cas.ll_getDoubleValue(addr, ((GeneConfidence_Type)jcasType).casFeatCode_confidence);}
    
  /** setter for confidence - sets  
   * @generated */
  public void setConfidence(double v) {
    if (GeneConfidence_Type.featOkTst && ((GeneConfidence_Type)jcasType).casFeat_confidence == null)
      jcasType.jcas.throwFeatMissing("confidence", "edu.cmu.deiis.types.GeneConfidence");
    jcasType.ll_cas.ll_setDoubleValue(addr, ((GeneConfidence_Type)jcasType).casFeatCode_confidence, v);}    
  }

    