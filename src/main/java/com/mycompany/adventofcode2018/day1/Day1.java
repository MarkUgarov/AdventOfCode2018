/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.adventofcode2018.day1;

import com.mycompany.adventofcode2018.TestDataReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mark2d2
 */
public class Day1 {
    
    private static final String FILE_PATH = "TestDataDay1";
    private ArrayList<Integer> testData;
    private double value;

    
    public Day1(){
        try {
            this.testData = TestDataReader.getTestDataAsInteger(FILE_PATH);
        } catch (IOException ex) {
            Logger.getLogger(Day1.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }
    }
    
    public void printResults(){
        System.out.println("------------------------------------");
        System.out.println("DAY 1");
        System.out.println(this.getSum(testData));
        System.out.println(this.getFirstDuplicate(this.testData));
        System.out.println("------------------------------------");
        return;
    }
    
            
            
    public double getSum(ArrayList<Integer> data){
        this.value = 0;
        for (int i:data){
            this.value += i;
        }
        return value;
    }
    
    public double getFirstDuplicate(ArrayList<Integer> data){
        this.value = 0;
        ArrayList<Double> reachedValues = new ArrayList<>();
       
        int index = 0;
        boolean found = false;
        while (!found){
            this.value += data.get(index);
            if (reachedValues.contains(this.value)){
                found = true;
                System.out.println("found: "+ this.value);
            }
            else{
                reachedValues.add(value);
                index++;
                if (index >= data.size()){
                    index = 0;
                }
            }
        }
//        
//        for (double v:reachedValues){
//            System.out.println(v);
//        }
        return value;
    }
    
}
