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
public class SquareInch {
    
    private ArrayList<Rectangle> occupations;
    
    public SquareInch(){
        this.occupations = new ArrayList<>();
    }
    
    public int getOverlaps(){
        return this.occupations.size();
    }
    
    public void addOverlap(Rectangle r){
        for (Rectangle o:this.occupations){
            o.addOverlapWith(r);
            r.addOverlapWith(o);
        }
        this.occupations.add(r);
    }
    
    
    
}
