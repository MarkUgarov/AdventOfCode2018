/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.adventofcode2018.day2;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author mark2d2
 */
public class WordTouple {

    /**
     * @return the distance
     */
    public int getDistance() {
        return distance;
    }

    /**
     * @return the word1
     */
    public String getWord1() {
        return word1;
    }

    /**
     * @return the word2
     */
    public String getWord2() {
        return word2;
    }

    /**
     * @return the commonLetters
     */
    public ArrayList<Character> getCommonLetters() {
        return commonLetters;
    }

    /**
     * @param commonLetters the commonLetters to set
     */
    public void setCommonLetters(ArrayList<Character> commonLetters) {
        this.commonLetters = commonLetters;
    }
    
    private int distance;
    private String word1;
    private String word2;
    private ArrayList<Character> commonLetters;
    
    public WordTouple(String word1, String word2){
        this.word1 = word1.trim();
        this.word2 = word2.trim();
        this.commonLetters = new ArrayList<>();
        
        char c;
        this.distance = 0;
        for(int i= 0; i<this.word1.length() && i<this.word2.length(); i++){
            if(this.word1.charAt(i) == this.word2.charAt(i)){
                this.commonLetters.add(this.word1.charAt(i));
            }
            else{
                this.distance++;
            }
        }
    }
    
    public String commonLettersToString(){
        StringBuilder strBuild = new StringBuilder();
        for (char c: this.commonLetters){
            strBuild.append(c);
        }
        return strBuild.toString();
    }
   
    
}
