/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.adventofcode2018.day9;

import com.mycompany.adventofcode2018.Day;
import com.mycompany.adventofcode2018.TestDataReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mark2d2
 */
public class Day9 implements Day{
    
    private static final String FILE_PATH = "TestDataDay9";
    private ArrayList<String> testData;
    private int numberOfPlayers; 
    private int goalPoints; // this is the number of points of the last marble given by the input
    private Game game;
    
   
    
    public Day9(){
        try {
            this.testData = TestDataReader.getTestData(FILE_PATH);
        } catch (IOException ex) {
            Logger.getLogger(Day9.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }
    }

    @Override
    public void printResults() {
        System.out.println("------------------------------------");
        System.out.println("DAY 9");
        System.out.println(this.getHighScore(testData));
        System.out.println("------------------------------------");
        return;
    }
    
    private void parse(ArrayList<String> data){
        String[] args = data.get(0).split("\\s+");
        this.numberOfPlayers = Integer.parseInt(args[0]);
        this.goalPoints = Integer.parseInt(args[6]);
        
    }
    
    private void simulate(){
        this.game = new Game(this.numberOfPlayers);
        this.game.simulate(this.goalPoints);
    }
    
    public int getHighScore(ArrayList<String> data){
        this.parse(data);
//        System.out.println(this.numberOfPlayers+ " Players");
//        System.out.println(this.goalPoints +" Points for the last marble");
        this.simulate();
        
        return this.game.getMaxPlayerScore();
    }
}
