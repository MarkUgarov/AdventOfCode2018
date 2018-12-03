/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.adventofcode2018.day2;

import com.mycompany.adventofcode2018.Day;
import com.mycompany.adventofcode2018.TestDataReader;
import com.mycompany.adventofcode2018.day1.Day1;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mark2d2
 */
public class Day2 implements Day{
    
    private static final String FILE_PATH = "TestDataDay2";
    private ArrayList<String> testData;
    
    
    private ArrayList<Integer> appearancesCounter;
    
   
    public Day2(){
        try {
            this.testData = TestDataReader.getTestData(FILE_PATH);
        } catch (IOException ex) {
            Logger.getLogger(Day1.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }
        this.appearancesCounter = new ArrayList<>();
        
    }
    
    @Override
    public void printResults(){
        System.out.println("------------------------------------");
        System.out.println("DAY 2");
        System.out.println(this.getCheckProduct(this.testData));
        System.out.println(this.getMostCommon(testData));   
        System.out.println("------------------------------------");
        return;
    }
    
    
    
    public int getCheckProduct(ArrayList<String> data){
        ArrayList<Integer> currAppearanceCounter;
        this.appearancesCounter = new ArrayList<>();
        int v;
        for (String d:data){
            currAppearanceCounter = this.getAppearancesCounterForWord(d);
            //System.out.println("Word "+d);
            for (int index = 2; 
                    index<currAppearanceCounter.size() 
                    && index <= 3; // we only check 2 and 3
                    index++){
                v = (appearancesCounter.size()<=index || appearancesCounter.get(index) ==  null)?0:appearancesCounter.get(index);
                this.appearancesCounter= this.setValue(index, currAppearanceCounter.get(index)+ v, appearancesCounter);
            }
            
        }
        int checkProduct = 0;
        for (int i:this.appearancesCounter){
            if (checkProduct == 0){
                checkProduct = i;
            }
            else if(i != 0){
                checkProduct=  Math.max(checkProduct, 1)*i;
            }
        }
        return checkProduct;
        
    }
    
    public ArrayList<Integer> getAppearancesCounterForWord(String arg){
        int[] charAppearances = this.getAppearancesForWord(arg);
        ArrayList<Integer> appCounter = new ArrayList<>();
        for(int index:charAppearances){
            if (index > 0){
                //System.out.println("Set index "+index+" to 1");
                appCounter = this.setValue(index, 1, appCounter);
            }
            
        }
        appCounter.remove(null);
        return appCounter;
    }
    
    public int[] getAppearancesForWord(String arg){
        int[] charAppearances = new int[27];
        //init the array
        for (int i = 0; i<charAppearances.length; i++){
            charAppearances[i] = 0;
        }
        char c;
        int charIndex;
        String word = arg.trim();
        for (int i = 0; i< word.length(); i++){
            c = word.charAt(i);
            charIndex = this.getNumForChar(Character.toLowerCase(c));
            charAppearances[charIndex] = charAppearances[charIndex] +1;
        }
        return charAppearances;
    }
    
    
    private void addToAppearancesCounter(int index){
        if(this.appearancesCounter.size()<=index){
            this.appearancesCounter.set(index, 1);
        }
        else{
            int val;
            val = (this.appearancesCounter.get(index) == null)? 1:this.appearancesCounter.get(index)+1;
            appearancesCounter = this.setValue(index, val, appearancesCounter);
        }
    }
    
    private ArrayList<Integer> setValue(int index, int value, ArrayList<Integer> arrList){
        while(arrList.size() <= index){
            arrList.add(0);
        }
        arrList.set(index, value);
        return arrList;
    }
    
    private int getNumForChar(char c){
        int val = "abcdefghijklmnopqrstuvwxyz".indexOf(c);
        if (val <0){
            System.out.println (c+" not found, returning 26 ");
            return 26;
        }
        return val;
    }
    
    private WordTouple getMinimalDistantWords(ArrayList<String> data){
        ArrayList<WordTouple> touples = new ArrayList<>();
        boolean found = false;
        WordTouple currTouple;
        for (int i=0; i<data.size() && !found; i++){
            for (int j = i+1 ; j<data.size() && !found; j++){
                currTouple = new WordTouple(data.get(i), data.get(j));
                touples.add(currTouple);
                if(currTouple.getDistance() == 0 ){
                    found = true;
                }
            }
        }
        Collections.sort(touples, 
                new Comparator<WordTouple>() {
                    @Override
                    public int compare(WordTouple o1, WordTouple o2) {
                        return o1.getDistance()- o2.getDistance();
                    }
                }
        );
//        for (WordTouple wt:touples){
//            System.out.println("Common String "+wt.commonLettersToString()+" with distance "+ wt.getDistance());
//        }
        return (touples.size() == 0)? null: touples.get(0);
    }
    
    public String getMostCommon(ArrayList<String> data){
        WordTouple closestWords = this.getMinimalDistantWords(data);
        if (closestWords == null){
            return "";
        }
        String ret = closestWords.commonLettersToString();
        
        System.out.println("Most common Substring: "+ret+" with distance "+closestWords.getDistance());
        return ret;
    }
    
}
