

/* First created by JCasGen Mon Sep 29 01:21:59 EDT 2014 */
package edu.cmu.deiis.types;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;


/** 
 * Updated by JCasGen Mon Sep 29 01:21:59 EDT 2014
 * XML source: /home/happyuser/git/hw2-zhouchel/hw2-zhouchel/src/main/resources/descriptors/deiis_types.xml
 * @generated */
public class GeneTag extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(GeneTag.class);
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
  protected GeneTag() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public GeneTag(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public GeneTag(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public GeneTag(JCas jcas, int begin, int end) {
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
    if (GeneTag_Type.featOkTst && ((GeneTag_Type)jcasType).casFeat_id == null)
      jcasType.jcas.throwFeatMissing("id", "edu.cmu.deiis.types.GeneTag");
    return jcasType.ll_cas.ll_getStringValue(addr, ((GeneTag_Type)jcasType).casFeatCode_id);}
    
  /** setter for id - sets  
   * @generated */
  public void setId(String v) {
    if (GeneTag_Type.featOkTst && ((GeneTag_Type)jcasType).casFeat_id == null)
      jcasType.jcas.throwFeatMissing("id", "edu.cmu.deiis.types.GeneTag");
    jcasType.ll_cas.ll_setStringValue(addr, ((GeneTag_Type)jcasType).casFeatCode_id, v);}    
   
    
  //*--------------*
  //* Feature: gene

  /** getter for gene - gets 
   * @generated */
  public String getGene() {
    if (GeneTag_Type.featOkTst && ((GeneTag_Type)jcasType).casFeat_gene == null)
      jcasType.jcas.throwFeatMissing("gene", "edu.cmu.deiis.types.GeneTag");
    return jcasType.ll_cas.ll_getStringValue(addr, ((GeneTag_Type)jcasType).casFeatCode_gene);}
    
  /** setter for gene - sets  
   * @generated */
  public void setGene(String v) {
    if (GeneTag_Type.featOkTst && ((GeneTag_Type)jcasType).casFeat_gene == null)
      jcasType.jcas.throwFeatMissing("gene", "edu.cmu.deiis.types.GeneTag");
    jcasType.ll_cas.ll_setStringValue(addr, ((GeneTag_Type)jcasType).casFeatCode_gene, v);}    
  }

    