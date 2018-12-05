/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.adventofcode2018.day5;

import com.mycompany.adventofcode2018.Day;
import com.mycompany.adventofcode2018.TestDataReader;
import com.mycompany.adventofcode2018.day1.Day1;
import com.mycompany.adventofcode2018.day4.Guard;
import com.mycompany.adventofcode2018.day4.PointOfTime;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author black
 */
public class Day5 implements Day{
    
    private static final String FILE_PATH = "TestDataDay5";
    private ArrayList<String> testData;
    
    private StringBuffer content;

    
    public Day5(){
        try {
            this.testData = TestDataReader.getTestData(FILE_PATH);
        } catch (IOException ex) {
            Logger.getLogger(Day1.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }
    }

    @Override
    public void printResults() {
        System.out.println("------------------------------------");
        System.out.println("DAY 5");
        System.out.println(this.getLengthAfterReaction(testData));
        System.out.println(this.getMinLenghtByCleaningChars(testData));
        System.out.println("------------------------------------");
        return;
    }
    
    private void parse(ArrayList<String> data){
        this.content = new StringBuffer(data.get(0));
        if (data.size() !=1){
            System.out.println("MULTIPLE LINES!!!");
        }
        
    }
    
    public String applyReaction(ArrayList<String> data){
        this.parse(data);
        this.react();
        String[] cs = this.content.toString().split("(?<=\\G.{50})");
//        for (String c: cs ){
//            System.out.println(c);
//        }
        return this.content.toString();
    }
    
    
    private void react(){
        boolean reacted = false;
        char last;
        char current;
       // System.out.println("React "+this.content.toString());
        int index=1;
        while (index<this.content.length()){
            last = this.content.charAt(index-1);
            current = this.content.charAt(index);
            if (this.charMatching(current, last)){
                this.content.deleteCharAt(index);
                this.content.deleteCharAt(index-1);
                reacted = true;
                //System.out.println("Reacted:" +last+" and "+current);
                
            }
            else{
                index++;
            }
            
        }
        if (reacted){
            // we have to check again if the content was changed
            this.react();
        }
        else{
            this.check(this.content);
            return;
        }
            
    }
    
    private void check(StringBuffer str){
        char c1, c2;
        for (int i = 0; i<str.length()-1; i++){
            c1 = str.charAt(i);
            c2 = str.charAt(i+1);
            if (this.charMatching(c1,c2)){
                System.out.println ("MISSMATCH DETECTED AT "+ i+":"+c1 +"="+c2);
            }
        }
    }
    
    private boolean charMatching (char a, char b){
        return Character.isUpperCase(a) != Character.isUpperCase(b)
                && Character.toUpperCase(a) == Character.toUpperCase(b);
    }

    public int getLengthAfterReaction(ArrayList<String> data){
        //System.out.println ("Length before: "+data.get(0).length());
        int length =this.applyReaction(data).length();
        //System.out.println ("Length after: "+length);
        return length;
        
        //Test-Data: 12264 is to high!!! 9116 it should be 
    }
    
    private void clearChar(char c){
        int i=0;
        char current;
        while (i < this.content.length()){
            current = this.content.charAt(i);
            if (Character.toUpperCase(c) == Character.toUpperCase(current)){
                this.content.deleteCharAt(i);
            }
            else{
                i++;
            }
        }
        
    }
    
    public int getMinLenghtByCleaningChars(ArrayList<String> data){
        int minLength = Integer.MAX_VALUE;
        for (char alphabet = 'A'; alphabet <= 'Z'; alphabet++) {
            this.parse(data);
            this.clearChar(alphabet);
            this.react();
            if (this.content.length() < minLength){
                minLength = this.content.length();
            }
        }
        return minLength;
    }
            
            
    
    
}
