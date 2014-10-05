package edu.cmu.deiis.analysisEngine;

import java.util.ArrayList;

import abner.Tagger;

public class Abner {
  private Tagger tagger;
  public Abner() {
    tagger = new Tagger(Tagger.NLPBA);
  }
  
  public Iterable<String> chunk(String text) {
    ArrayList<String> result = new ArrayList<String>();
    if (this.tagger == null)
      return null;
    else {
      String[][] chunk = tagger.getEntities(text);
      for (int i = 0; i < chunk[0].length; i++) {
        //if (chunk[1][i].equals("B-DNA"))
          result.add(chunk[0][i]);
      }
      return result;
    }
  }
}
