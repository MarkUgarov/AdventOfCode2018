/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.adventofcode2018.day4;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author mark2d2
 */
public class TimeFrame {

    private Date start;
    private Date end;
    
    public TimeFrame(Date start){
        this.start = start;
    }
    
    public TimeFrame(PointOfTime startPoint){
        this.start = startPoint.getDate();
    }
    
     /**
     * @return the start
     */
    public Date getStart() {
        return start;
    }

    /**
     * @param start the start to set
     */
    public void setStart(Date start) {
        this.start = start;
    }
    
    public void setStart(PointOfTime event){
        this.start = event.getDate();
    }

    /**
     * @return the end
     */
    public Date getEnd() {
        return end;
    }

    /**
     * @param end the end to set
     */
    public void setEnd(Date end) {
        this.end = end;
    }
    
    public void setEnd(PointOfTime event){
        this.end = event.getDate();
    }
    
    public long getDurationInMinutes(){
        long durationMillisec = 0;
        if (this.start != null && this.end != null){
            durationMillisec = this.end.getTime() - this.start.getTime();
            
        }
        return TimeUnit.MILLISECONDS.toMinutes(durationMillisec);
    }

    
    
}
