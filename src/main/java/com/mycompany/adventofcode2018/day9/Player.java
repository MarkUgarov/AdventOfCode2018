/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.adventofcode2018.day9;

/**
 *
 * @author mark2d2
 */
public class Player implements CircleElement {
    
    private int playerIndex;
    private int scoreSum;
    
    public Player(int index){
        this.playerIndex = 0;
        this.scoreSum = 0;  
    }
    
    public void addToScore(int marblePoints){
        this.scoreSum += marblePoints;
    }
    
    @Override
    public int getScore(){
        return this.scoreSum;
    }
}
