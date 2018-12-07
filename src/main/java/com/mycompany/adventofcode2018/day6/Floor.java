/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.adventofcode2018.day6;

import java.util.ArrayList;

/**
 *
 * @author mark2d2
 */
public class Floor {
    
    private int xDim;
    private int yDim;
    
    private ArrayList<ArrayList<Tile>> content;
    private ArrayList<MajorTile> majorTiles;
    
    public Floor(){
        this.content = new ArrayList<>();
        this.majorTiles = new ArrayList<>();
        this.xDim = 0;
        this.yDim = 0;
    }
    
    public void addMajorToFloor(int x, int y){
        this.xDim = Math.max(x, this.xDim);
        this.yDim = Math.max(y, this.yDim);
        MajorTile mj= new MajorTile (x,y);
        while(x>=this.content.size()){
            this.content.add(new ArrayList<Tile>());
        }
        ArrayList<Tile> yAxe = this.content.get(x);
        int j = yAxe.size();
        while (y>=yAxe.size()){
            yAxe.add(new Tile(x,j));
            j++;
        }
        yAxe.set(y, mj);
        this.majorTiles.add(mj);
    }
    
    public void fillToMaxValues(){
        ArrayList<Tile> yAxis;
        for(int i = 0; i<this.content.size();i++){
            yAxis = this.content.get(i);
            while(yAxis.size() <= this.yDim){
                yAxis.add(new Tile(i,yAxis.size()));
            }
        }
    }
    
    public void findChildren(){
        int currentMajorDistance;
        int candidateDistance;
        for(ArrayList<Tile> at: this.content){
            for (Tile t:at){
                if(!t.isMajor()){
                    currentMajorDistance = t.getDistanceToCurrentOrLastMajor();
                    for(MajorTile mt:this.majorTiles){
                        candidateDistance = t.getManhattenDistanceTo(mt);
                        if(currentMajorDistance > candidateDistance){
                            t.setMajor(mt);
                            currentMajorDistance = t.getDistanceToCurrentOrLastMajor();

                        }
                        else if (currentMajorDistance == candidateDistance){
                            t.setMajor(null);
                            currentMajorDistance = t.getDistanceToCurrentOrLastMajor();

                        }
                        // else: do nothing
                    }
                    
                }
                
            }
        }
    }
    
    public void println(){
        for (ArrayList<Tile> at:this.content){
            for (Tile t: at){
                System.out.print(t.getGenericName()
                        //+ String.format("%1$2s", ""+t.getDistanceToCurrentOrLastMajor())
                        +"|");
            }
            System.out.println();
        }
    }
    
    private char getCharForNum(int a){
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        if (a>=alphabet.length()){
            return 8;
        }
        else {
            return alphabet.charAt(a);
        }
    }
    
    public int getBiggestMajorArea(){
        int maxVal = 0;
        int currVal;
        MajorTile currMax;
        for(MajorTile mj:this.majorTiles){
            currVal = mj.getArea(this.xDim, this.yDim);
            if(currVal > maxVal){
                maxVal = currVal;
                currMax=mj;
                        
            }
            //maxVal = Math.max(mj.getArea(this.xDim, this.yDim), maxVal);
        }
        return maxVal;    
        //8641 is to high!
    }

   
    
}
