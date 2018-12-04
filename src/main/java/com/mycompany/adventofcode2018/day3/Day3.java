/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.adventofcode2018.day3;

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
        System.out.println(this.getRectangleIDWithoutOverlap(testData));
        System.out.println("------------------------------------");
        return;
    }
    
    private void parse(ArrayList<String> data){
        this.rectangles = new ArrayList<>();
        for(String s: data){
            this.rectangles.add(new Rectangle(s));
        }
    }
    
    private void initFloor(){
        this.floor = new Floor();
        for (Rectangle r:this.rectangles){
            this.floor.addFabric(r);
        }
    }
    
    public int getNumberOfOverlappedSquareInches(ArrayList<String> data){
        this.parse(data);
        this.initFloor();
        return floor.getOverlaps();
    }
    
    public String getRectangleIDWithoutOverlap(ArrayList<String> data){
        this.parse(data);
        this.initFloor();
        boolean found = false;
        String ret = "NOTHING FOUND";
        Rectangle current;
        for (int i=0; !found && i<this.rectangles.size(); i++){
            current = this.rectangles.get(i);
            if(!current.hasOverlaps()){
                found = true;
                ret = ""+current.getID();
            }
        }
        return ret;
    }
    
}
