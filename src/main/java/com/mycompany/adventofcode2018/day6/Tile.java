/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.adventofcode2018.day6;

/**
 *
 * @author mark2d2
 */
public class Tile {
    
    private int x;
    private int y;
    private MajorTile major;
    private int distanceToMajor;
    
    public Tile(int x, int y){
        this.x =x;
        this.y =y;
        this.distanceToMajor = Integer.MAX_VALUE;
    }
    
    public boolean isMajor(){
        return false;
    }
    
    public void setMajor(MajorTile mt){
        if (this.major != null){
            this.major.removeChild(this);
        }
        this.major = mt;
        if (this.major != null){
            this.major.addToChildren(this);
        }
        this.distanceToMajor = this.getManhattenDistanceTo(this.major);
    }
    
    public MajorTile belongsTo(){
        return this.major;
    }
    
    public int getX(){
        return this.x;
    }
    
    public int getY(){
        return this.y;
    }
    
    public int getManhattenDistanceTo(Tile t){
        if (this.major == null || t == null){
            return Integer.MAX_VALUE;
        }
        return Math.abs((this.x - t.getX())+(this.y-t.getY()));
    }
    
    public int getDistanceToCurrentMajor(){
        return this.distanceToMajor;
    }
    
    
}
