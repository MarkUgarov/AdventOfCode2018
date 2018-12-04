/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.adventofcode2018.day4;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author mark2d2
 */
public class Guard implements Comparable<Guard>{
    
    private ArrayList<TimeFrame> sleepTimes;
    private int[] sleepMinutes;
    private ArrayList<TimeFrame> shifts;
    private final String ID;
    
    private TimeFrame currentSleepFrame;
    private TimeFrame currentShift;
    
    public Guard (String id){
        this.sleepTimes = new ArrayList<>();
        this.ID = id;
        this.sleepMinutes = new int[60];
        for (int i = 0; i<60; i++){
            this.sleepMinutes[i]=0;
        }
    }
    

    
    public void addEvent(PointOfTime event){
        if (event.getMessage().trim().equals("wakes up")){
            this.addWakupTime(event);
        }
        else if(event.getMessage().trim().equals("falls asleep")){
            this.addSleepStart(event);
        }
        else if(event.getMessage().trim().equals("begins shift") ){
            if (event.describedGuard().equals(this.ID)){
                this.addShift(event);
            }
            else{
                this.endShift(event);
            }
        }
        // else: do nothing
    }
    
    public void addShift(PointOfTime event){
        this.currentShift = new TimeFrame(event);
        this.shifts.add(currentShift);
    }
    
    public void endShift(PointOfTime event){
        if (this.currentShift != null){
            this.currentShift.setEnd(event);
        }
    }
    
    private void addWakupTime(PointOfTime event){
        if (this.currentSleepFrame != null){
            this.currentSleepFrame.setEnd(event);
            Calendar start = Calendar.getInstance();
            Calendar end = Calendar.getInstance();
            start.setTime(this.currentSleepFrame.getStart());
            end.setTime(this.currentSleepFrame.getEnd());
            for (int i = start.get(Calendar.MINUTE); i<end.get(Calendar.MINUTE); i++){
                this.sleepMinutes[i] = this.sleepMinutes[i]+1;
            }  
        }
    }
    
    private void addSleepStart(PointOfTime event){
        this.currentSleepFrame = new TimeFrame(event);
        this.sleepTimes.add(currentSleepFrame);
       
    }
    
    public long getSleepTime(){
        long sleepTime = 0;
        for (TimeFrame f:this.sleepTimes){
            sleepTime += f.getDurationInMinutes();
        }
        return sleepTime;
    }
    
    public int getMinuteWithMaxSleep(){
        int max = 0;
        int maxIndex=0;
        int currVal;
        for (int index = 0;index<this.sleepMinutes.length; index++){
            currVal = this.sleepMinutes[index];
            if (currVal>max){
                max = currVal;
                maxIndex =index;
            }
        }
        return maxIndex;
    }
    
    public int getValueOfMinuteWithMaxSleep(){
        int max = 0;
        for (int i:this.sleepMinutes){
            if (i>max){
                max = i;
            }
        }
        return max;
    }
    
    public String getId(){
        return this.ID;
    }
    
    public int getIdAsInt(){
        return Integer.parseInt(this.ID);
    }

    @Override
    public int compareTo(Guard o) {
        long sleepTime1 = this.getSleepTime();
        long sleepTime2 = o.getSleepTime();
        if (sleepTime1<sleepTime2) {
            return -1;
        }
        else if (sleepTime1>sleepTime2) {
            return 1;
        } 
        else {
            return 0;
        }
    }
    
}
