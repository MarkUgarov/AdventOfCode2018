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
public class MajorTile extends Tile{
    
    private ArrayList<Tile> children;
    private boolean infinitive;
    
    public MajorTile(int x, int y) {
        super(x, y);
        this.children = new ArrayList<>();
        //this.children.add(this);
        this.infinitive = false;
        super.setMajor(this);
    }
    
    @Override
    public boolean isMajor(){
        return true;
    }
    
    @Override
    public void setMajor(MajorTile mt){
        // do nothing
    }
    
    public void addToChildren(Tile tile){
        if (!tile.isMajor()){
            this.children.add(tile);
        }
        
    }
    
    public void removeChild(Tile tile){
        Tile currChild;
        int i = 0;
        while(i<this.children.size()){
            currChild = this.children.get(i);
            if (currChild.getX() == tile.getX() && currChild.getY() == tile.getY()){
                this.children.remove(i);
            } 
            else{
                i++;
            }
        }
    }
    
    
    public int getArea(){
        if (this.infinitive){
            return -1;
        }
        else {
            return this.children.size()+1;
        }
    }
    
    @Override
    public int getDistanceToCurrentOrLastMajor(){
        return 0;
    }
    
    @Override
    public boolean isInfinite(int maxX, int maxY){
        boolean infinite = super.isInfinite(maxX, maxY);
        int i = 0;
        while(!infinite && i<this.children.size()){
            infinite = this.children.get(i).isInfinite(maxX, maxY);
            i++;
        }
        return infinite;
    }
    
    public int getArea(int maxX, int maxY){
        return (this.isInfinite(maxX, maxY)) ? -1 : this.children.size();
    }
    
    @Override
    public String getGenericName(){
        return  ""
                + Character.toUpperCase(this.getCharForNum(this.getMajorTile().getX()))
                + ""
                + Character.toUpperCase(this.getCharForNum(this.getMajorTile().getY()));

    }


    private char getCharForNum(int a){
        String alphabet = "abcdefghijklmnopqrstuvwxy";
        if (a>=alphabet.length()){
            return 'z';
        }
        else {
            return alphabet.charAt(a);
        }
    }
}
