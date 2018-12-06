/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.adventofcode2018.day4;

import com.mycompany.adventofcode2018.Day;
import com.mycompany.adventofcode2018.TestDataReader;
import com.mycompany.adventofcode2018.day1.Day1;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mark2d2
 */
public class Day4 implements Day{
    
    private static final String FILE_PATH = "TestDataDay4";
    private ArrayList<String> testData;

    private ArrayList<PointOfTime> timestamps;
    private ArrayList<Guard> guards;
    
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
        System.out.println(this.getProductOfIdAndMaxSleepMinute(testData));
        System.out.println(this.getProductOfIdAndValueOfMaxSleepMinute(testData));
        System.out.println("------------------------------------");
        return;
    }
    
    private void parse(ArrayList<String> data){
        this.timestamps = new ArrayList<>();
        this.guards = new ArrayList();
        for (String d: data){
            timestamps.add(new PointOfTime(d));
        }
        timestamps.sort(null); // is comparable, doesn't nee a Comparator     

        Guard lastGuard = new Guard("-1"); // just initialisation, should not matter
        for(PointOfTime d:this.timestamps){
            this.addInfoToGuard(lastGuard, d);
            if (d.describedGuard() != null){
                lastGuard = this.getGuard(d.describedGuard());
                this.addInfoToGuard(lastGuard, d);
            }
        }
        this.guards.sort(null); // comparable by sleeptime, therefore no need for Comparator
        Collections.reverse(this.guards);
//        for (Guard g:this.guards){
//            System.out.println(g.getId()+":"+g.getSleepTime());
//        }
        
    }
    
    private void addInfoToGuard(Guard guard, PointOfTime event){
        if (guard != null && event != null){
            guard.addEvent(event);
        }
    }
    
    private Guard getGuard(String id){
        Guard foundGuard = null;
        int counter = 0; 
        Guard currentGuard;
        while (foundGuard == null && counter<this.guards.size()){
            currentGuard = this.guards.get(counter);
            if (currentGuard.getId().equals(id)){
                foundGuard = currentGuard;
            }
            counter++;
        }
        if (foundGuard == null){
            foundGuard = new Guard(id);
            this.guards.add(foundGuard);
//            System.out.println("Added guard "+foundGuard.getId());
        }
        return foundGuard;
    }

    public Guard getGuardWithMostSleep(ArrayList<String> data){
        this.parse(data);
        if (this.guards.size() == 0){
            return null;
        }
        else {
            return this.guards.get(0);
        }
    }
    
    public int getProductOfIdAndMaxSleepMinute(ArrayList<String> data){
        Guard fool = this.getGuardWithMostSleep(data);
        return (fool.getIdAsInt()* fool.getMinuteWithMaxSleep());
    }
    
    public int getProductOfIdAndValueOfMaxSleepMinute(ArrayList<String> data){
        this.parse(data);
        Guard mostRegularGuard = this.guards.get(0);
        System.out.println(this.guards.size()+" guards found");
        for (Guard g: this.guards){
            if (g.getValueOfMinuteWithMaxSleep()>mostRegularGuard.getValueOfMinuteWithMaxSleep()){
                mostRegularGuard = g;
            }
            //System.out.println(g.getId()+":"+g.getValueOfMinuteWithMaxSleep()+" on Minute "+g.getMinuteWithMaxSleep());
        }
        
        return (mostRegularGuard.getIdAsInt()* mostRegularGuard.getMinuteWithMaxSleep());
    }
    
}
