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

    private final int x;
    private final int y;
    private MajorTile major;
    private int distanceToMajor; // can be the distance to the LAST major has been set to null

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
        if (mt != null){
            mt.addToChildren(this);
            this.distanceToMajor = this.getManhattenDistanceTo(mt);   
        }//else: do not change distanceToMajor!
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
        if (t == null){
            return Integer.MAX_VALUE;
        }
        return (Math.abs(this.x - t.getX())+Math.abs(this.y-t.getY()));
    }

    public int getDistanceToCurrentOrLastMajor(){
        return this.distanceToMajor;
    }

    public boolean isInfinite(int maxX, int maxY){
        return (this.x == 0 || this.y == 0 || 
                this.x == maxX || this.y == maxY);
    }

    public MajorTile getMajorTile(){
        return this.major;
    }

    public String getGenericName(){
        return  (this.major == null)?
                "..":
                //this.getCharForNum(x)
                this.getCharForNum(this.getMajorTile().getX())
                + ""
                //+ this.getCharForNum(y);
                + this.getCharForNum(this.getMajorTile().getY());

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
