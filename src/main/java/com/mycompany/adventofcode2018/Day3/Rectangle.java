/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.adventofcode2018.Day3;

import java.util.ArrayList;

/**
 *
 * @author mark2d2
 */
public class Rectangle {

    /**
     * @return the ID
     */
    public int getID() {
        return ID;
    }

    /**
     * @return the fromLeft
     */
    public int getFromLeft() {
        return fromLeft;
    }

    /**
     * @return the fromTop
     */
    public int getFromTop() {
        return fromTop;
    }

    /**
     * @return the width
     */
    public int getWidth() {
        return width;
    }

    /**
     * @return the hight
     */
    public int getHight() {
        return hight;
    }
    
    private int ID;
    private int fromLeft;
    private int fromTop;
    
    private int width;
    private int hight;
    
    private ArrayList<Rectangle> overlapsWith;
    
    public Rectangle(String line){
        String[] args = line.split("\\s+");
        String id = args[0].replace("#", "");
        String[] coordinates = args[2].replace(":", "").split(",");
        String[] dimensions = args[3].split("x");
        
        this.ID = this.parseInt(id);
        
        this.fromLeft = this.parseInt(coordinates[0]);
        this.fromTop = this.parseInt(coordinates[1]);
        
        this.width = this.parseInt(dimensions[0]);
        this.hight = this.parseInt(dimensions[1]);
        
        this.overlapsWith = new ArrayList<>();
        
    }
    
    private int parseInt(String val){
        try{
             return Integer.parseInt(val);
        }
        catch (NumberFormatException e) {
            return -1;
        }
    }
    
    public String print(){
        String ret = (getID()+": "+ getFromLeft()+","+getFromTop()+" = "+getWidth()+ "x"+getHight());
        System.out.println(ret);
        return ret;
    }
    
    public void addOverlapWith(Rectangle r){
        this.overlapsWith.add(r);
    }
    
    public boolean hasOverlaps(){
        return (this.overlapsWith.size() > 0);
    }
}
