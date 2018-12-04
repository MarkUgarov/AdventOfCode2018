/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.adventofcode2018.day4;

import com.mycompany.adventofcode2018.Day;
import com.mycompany.adventofcode2018.TestDataReader;
import com.mycompany.adventofcode2018.day1.Day1;
import com.mycompany.adventofcode2018.day3.Floor;
import com.mycompany.adventofcode2018.day3.Rectangle;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mark2d2
 */
public class Day4 implements Day{
    
    private static final String FILE_PATH = "TestDataDay4";
    private ArrayList<String> testData;

    
    public Day4(){
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
        System.out.println("DAY 4");
        System.out.println("------------------------------------");
        return;
    }
    
    private void parse(ArrayList<String> data){
        ArrayList<PointOfTime> timestamps = new ArrayList<>();
        for (String d: data){
            timestamps.add(new PointOfTime(d));
        }
        timestamps.sort(null);

        System.out.println("Compared");
        for(PointOfTime d:timestamps){
            
            System.out.println(d.getDateString()+ " == "+ d.getMessage()+" || "+ d.describedGuard());
        }
        
    }
    
    
    public String getGuardWithMostSleep(ArrayList<String> data){
        this.parse(data);
        
        return null;
        
    }
    
}
