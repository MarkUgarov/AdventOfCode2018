/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.adventofcode2018.day15.figures;

/**
 *
 * @author mark2d2
 */
public class Coordinates {
    
    private int x;
    private int y;
    
    public Coordinates(int x, int y){
        this.set(x, y);
    }
    
    public int getX(){
        return this.x;
    }
    
    public int getY(){
        return this.y;
    }
    
    public void set(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    
    
}
