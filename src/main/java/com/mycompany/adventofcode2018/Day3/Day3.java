/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.adventofcode2018.Day3;

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
public class Day3 implements Day{
    private static final String FILE_PATH = "TestDataDay3";
    private ArrayList<String> testData;
    
    private ArrayList<Rectangle> rectangles;
    private Floor floor;
    
    public Day3(){
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
        System.out.println("DAY 3");
        System.out.println(this.getNumberOfOverlappedSquareInches(testData));
        System.out.println("------------------------------------");
        return;
    }
    
    private void parse(ArrayList<String> data){
        this.rectangles = new ArrayList<>();
        for(String s: data){
            this.rectangles.add(new Rectangle(s));
        }
    }
    
    public int getNumberOfOverlappedSquareInches(ArrayList<String> data){
        this.parse(data);
        this.floor = new Floor();
        for (Rectangle r:this.rectangles){
            this.floor.addFabric(r);
        }
        return floor.getOverlaps();
    }
    
}
