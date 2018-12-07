/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.adventofcode2018.day6;

import com.mycompany.adventofcode2018.Day;
import com.mycompany.adventofcode2018.TestDataReader;
import com.mycompany.adventofcode2018.day1.Day1;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mark2d2
 */
public class Day6 implements Day{
    
    private static final String FILE_PATH = "TestDataDay6";
    private ArrayList<String> testData;
    
    private Floor floor;
    
    public Day6(){
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
        System.out.println("DAY 6");
        System.out.println(this.getBiggestArea(testData));
        System.out.println("------------------------------------");
        return;
    }
    
    private void parse(ArrayList<String> data){
        this.floor = new Floor();
        int[] vals;
        for(String d: data){
            vals = this.getVals(d);
            if (vals != null){
                this.floor.addMajorToFloor(vals[0], vals[1]);  
            }   
        }
        this.floor.fillToMaxValues();
        //this.floor.println();
        System.out.println("_");
        this.floor.findChildren();
        //this.floor.println();
        
    }
    
    private int[] getVals(String data){
        String[] vals;
        if (data == null  || data.length() == 0){
            return null;
        }
        vals = data.split(", ");
        return new int[]{
            Integer.parseInt(vals[0]),
            Integer.parseInt(vals[1])
        };
    }
    
    public int getBiggestArea(ArrayList<String> data){
        this.parse(data);
        return this.floor.getBiggestMajorArea();
    }
}
