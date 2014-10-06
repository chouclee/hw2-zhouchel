
/* First created by JCasGen Sun Oct 05 20:12:56 EDT 2014 */
package edu.cmu.deiis.types;

import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.cas.impl.CASImpl;
import org.apache.uima.cas.impl.FSGenerator;
import org.apache.uima.cas.FeatureStructure;
import org.apache.uima.cas.impl.TypeImpl;
import org.apache.uima.cas.Type;
import org.apache.uima.cas.impl.FeatureImpl;
import org.apache.uima.cas.Feature;
import org.apache.uima.jcas.tcas.Annotation_Type;

/** 
 * Updated by JCasGen Sun Oct 05 20:57:50 EDT 2014
 * @generated */
public class GeneConfidence_Type extends Annotation_Type {
  /** @generated */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (GeneConfidence_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = GeneConfidence_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new GeneConfidence(addr, GeneConfidence_Type.this);
  			   GeneConfidence_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new GeneConfidence(addr, GeneConfidence_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = GeneConfidence.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("edu.cmu.deiis.types.GeneConfidence");
 
  /** @generated */
  final Feature casFeat_id;
  /** @generated */
  final int     casFeatCode_id;
  /** @generated */ 
  public String getId(int addr) {
        if (featOkTst && casFeat_id == null)
      jcas.throwFeatMissing("id", "edu.cmu.deiis.types.GeneConfidence");
    return ll_cas.ll_getStringValue(addr, casFeatCode_id);
  }
  /** @generated */    
  public void setId(int addr, String v) {
        if (featOkTst && casFeat_id == null)
      jcas.throwFeatMissing("id", "edu.cmu.deiis.types.GeneConfidence");
    ll_cas.ll_setStringValue(addr, casFeatCode_id, v);}
    
  
 
  /** @generated */
  final Feature casFeat_gene;
  /** @generated */
  final int     casFeatCode_gene;
  /** @generated */ 
  public String getGene(int addr) {
        if (featOkTst && casFeat_gene == null)
      jcas.throwFeatMissing("gene", "edu.cmu.deiis.types.GeneConfidence");
    return ll_cas.ll_getStringValue(addr, casFeatCode_gene);
  }
  /** @generated */    
  public void setGene(int addr, String v) {
        if (featOkTst && casFeat_gene == null)
      jcas.throwFeatMissing("gene", "edu.cmu.deiis.types.GeneConfidence");
    ll_cas.ll_setStringValue(addr, casFeatCode_gene, v);}
    
  
 
  /** @generated */
  final Feature casFeat_sentence;
  /** @generated */
  final int     casFeatCode_sentence;
  /** @generated */ 
  public String getSentence(int addr) {
        if (featOkTst && casFeat_sentence == null)
      jcas.throwFeatMissing("sentence", "edu.cmu.deiis.types.GeneConfidence");
    return ll_cas.ll_getStringValue(addr, casFeatCode_sentence);
  }
  /** @generated */    
  public void setSentence(int addr, String v) {
        if (featOkTst && casFeat_sentence == null)
      jcas.throwFeatMissing("sentence", "edu.cmu.deiis.types.GeneConfidence");
    ll_cas.ll_setStringValue(addr, casFeatCode_sentence, v);}
    
  
 
  /** @generated */
  final Feature casFeat_processedId;
  /** @generated */
  final int     casFeatCode_processedId;
  /** @generated */ 
  public int getProcessedId(int addr) {
        if (featOkTst && casFeat_processedId == null)
      jcas.throwFeatMissing("processedId", "edu.cmu.deiis.types.GeneConfidence");
    return ll_cas.ll_getIntValue(addr, casFeatCode_processedId);
  }
  /** @generated */    
  public void setProcessedId(int addr, int v) {
        if (featOkTst && casFeat_processedId == null)
      jcas.throwFeatMissing("processedId", "edu.cmu.deiis.types.GeneConfidence");
    ll_cas.ll_setIntValue(addr, casFeatCode_processedId, v);}
    
  
 
  /** @generated */
  final Feature casFeat_confidence;
  /** @generated */
  final int     casFeatCode_confidence;
  /** @generated */ 
  public double getConfidence(int addr) {
        if (featOkTst && casFeat_confidence == null)
      jcas.throwFeatMissing("confidence", "edu.cmu.deiis.types.GeneConfidence");
    return ll_cas.ll_getDoubleValue(addr, casFeatCode_confidence);
  }
  /** @generated */    
  public void setConfidence(int addr, double v) {
        if (featOkTst && casFeat_confidence == null)
      jcas.throwFeatMissing("confidence", "edu.cmu.deiis.types.GeneConfidence");
    ll_cas.ll_setDoubleValue(addr, casFeatCode_confidence, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public GeneConfidence_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_id = jcas.getRequiredFeatureDE(casType, "id", "uima.cas.String", featOkTst);
    casFeatCode_id  = (null == casFeat_id) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_id).getCode();

 
    casFeat_gene = jcas.getRequiredFeatureDE(casType, "gene", "uima.cas.String", featOkTst);
    casFeatCode_gene  = (null == casFeat_gene) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_gene).getCode();

 
    casFeat_sentence = jcas.getRequiredFeatureDE(casType, "sentence", "uima.cas.String", featOkTst);
    casFeatCode_sentence  = (null == casFeat_sentence) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_sentence).getCode();

 
    casFeat_processedId = jcas.getRequiredFeatureDE(casType, "processedId", "uima.cas.Integer", featOkTst);
    casFeatCode_processedId  = (null == casFeat_processedId) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_processedId).getCode();

 
    casFeat_confidence = jcas.getRequiredFeatureDE(casType, "confidence", "uima.cas.Double", featOkTst);
    casFeatCode_confidence  = (null == casFeat_confidence) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_confidence).getCode();

  }
}



    