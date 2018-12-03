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
public class Floor {
    
    private ArrayList<ArrayList<Integer>> describedFloor;
    
    public Floor(){
        this.describedFloor = new ArrayList<>();
    }
    
    public void addFabric(Rectangle fabric){
        for (int i = fabric.getFromLeft(); i<fabric.getFromLeft()+fabric.getWidth(); i++){
            for (int j = fabric.getFromTop(); j<fabric.getFromTop()+fabric.getHight(); j++){
                this.addToFloor(i, j);
            }
        }
    }
    
    public void addToFloor(int x, int y){
        while(x>=this.describedFloor.size()){
            this.describedFloor.add(new ArrayList<Integer>());
        }
        ArrayList<Integer> yAxe = this.describedFloor.get(x);
        while (y>=yAxe.size()){
            yAxe.add(0);
        }
        yAxe.set(y, yAxe.get(y)+1);
    }
    
    public int getOverlaps(){
        if (this.describedFloor == null || this.describedFloor.size() == 0){
            return 0;
        }
        int overlaps = 0;
        for (ArrayList<Integer> arrList: this.describedFloor){
            for (int i:arrList){
                if (i > 1){
                    overlaps++;
                }
                System.out.print(i);
            }
            //System.out.println("");
        }
        return overlaps;
    }
    
}
