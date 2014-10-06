

/* First created by JCasGen Mon Sep 29 01:21:59 EDT 2014 */
package edu.cmu.deiis.types;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;


/** 
 * Updated by JCasGen Sun Oct 05 20:57:50 EDT 2014
 * XML source: /home/happyuser/git/hw2-zhouchel/hw2-zhouchel/src/main/resources/descriptors/deiis_types.xml
 * @generated */
public class SentenceTag extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(SentenceTag.class);
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
  protected SentenceTag() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public SentenceTag(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public SentenceTag(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public SentenceTag(JCas jcas, int begin, int end) {
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
    if (SentenceTag_Type.featOkTst && ((SentenceTag_Type)jcasType).casFeat_id == null)
      jcasType.jcas.throwFeatMissing("id", "edu.cmu.deiis.types.SentenceTag");
    return jcasType.ll_cas.ll_getStringValue(addr, ((SentenceTag_Type)jcasType).casFeatCode_id);}
    
  /** setter for id - sets  
   * @generated */
  public void setId(String v) {
    if (SentenceTag_Type.featOkTst && ((SentenceTag_Type)jcasType).casFeat_id == null)
      jcasType.jcas.throwFeatMissing("id", "edu.cmu.deiis.types.SentenceTag");
    jcasType.ll_cas.ll_setStringValue(addr, ((SentenceTag_Type)jcasType).casFeatCode_id, v);}    
   
    
  //*--------------*
  //* Feature: sentence

  /** getter for sentence - gets 
   * @generated */
  public String getSentence() {
    if (SentenceTag_Type.featOkTst && ((SentenceTag_Type)jcasType).casFeat_sentence == null)
      jcasType.jcas.throwFeatMissing("sentence", "edu.cmu.deiis.types.SentenceTag");
    return jcasType.ll_cas.ll_getStringValue(addr, ((SentenceTag_Type)jcasType).casFeatCode_sentence);}
    
  /** setter for sentence - sets  
   * @generated */
  public void setSentence(String v) {
    if (SentenceTag_Type.featOkTst && ((SentenceTag_Type)jcasType).casFeat_sentence == null)
      jcasType.jcas.throwFeatMissing("sentence", "edu.cmu.deiis.types.SentenceTag");
    jcasType.ll_cas.ll_setStringValue(addr, ((SentenceTag_Type)jcasType).casFeatCode_sentence, v);}    
  }

    