/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.adventofcode2018.day3;

import java.util.ArrayList;

/**
 *
 * @author mark2d2
 */
public class Floor {
    
    private ArrayList<ArrayList<SquareInch>> describedFloor;
    
    public Floor(){
        this.describedFloor = new ArrayList<>();
    }
    
    public void addFabric(Rectangle fabric){
        for (int i = fabric.getFromLeft(); i<fabric.getFromLeft()+fabric.getWidth(); i++){
            for (int j = fabric.getFromTop(); j<fabric.getFromTop()+fabric.getHight(); j++){
                this.addToFloor(i, j, fabric);
            }
        }
    }
    
    public void addToFloor(int x, int y, Rectangle r){
        while(x>=this.describedFloor.size()){
            this.describedFloor.add(new ArrayList<SquareInch>());
        }
        ArrayList<SquareInch> yAxe = this.describedFloor.get(x);
        while (y>=yAxe.size()){
            yAxe.add(new SquareInch());
        }
        yAxe.get(y).addOverlap(r);
    }
    
    public int getOverlaps(){
        if (this.describedFloor == null || this.describedFloor.size() == 0){
            return 0;
        }
        int overlaps = 0;
        for (ArrayList<SquareInch> arrList: this.describedFloor){
            for (SquareInch i:arrList){
                if (i.getOverlaps() > 1){
                    overlaps++;
                }
                //System.out.print(i);
            }
            //System.out.println("");
        }
        return overlaps;
    }
    
}
