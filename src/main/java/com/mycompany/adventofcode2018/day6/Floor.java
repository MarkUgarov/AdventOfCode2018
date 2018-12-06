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
    
    private ArrayList<ArrayList<Tile>> content;
    private ArrayList<MajorTile> majorTiles;
    
    public Floor(){
        this.content = new ArrayList<>();
        this.majorTiles = new ArrayList<>();
    }
    
    public void addMajorToFloor(int x, int y){
        MajorTile mj= new MajorTile (x,y);
        while(x>=this.content.size()){
            this.content.add(new ArrayList<Tile>());
        }
        ArrayList<Tile> yAxe = this.content.get(x);
        while (y>=yAxe.size()){
            yAxe.add(new Tile(x,y));
        }
        yAxe.set(y, mj);
        this.majorTiles.add(mj);
    }
    
    public void println(){
        for (ArrayList<Tile> at:this.content){
            for (Tile t: at){
                if (t == null){
                    System.out.print(" ");
                }
                else if(t.isMajor()){
                    System.out.print("M");
                }
                else {
                    System.out.print(".");
                }
            }
            System.out.println();
        }
    }

   
    
}
