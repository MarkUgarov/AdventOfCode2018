/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.adventofcode2018.day15;

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
public class Day15 implements Day{
    
    private static final String FILE_PATH = "TestDataDay9";
    private ArrayList<String> testData;
    
    private Game game;

    public Day15(){
        try {
            this.testData = TestDataReader.getTestData(FILE_PATH);
        } catch (IOException ex) {
            Logger.getLogger(Day15.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }
    }

    @Override
    public void printResults() {
        System.out.println("------------------------------------");
        System.out.println("DAY 15");
        System.out.println("------------------------------------");
        return;
        
    }
    
    private void parse(ArrayList<String> data){
        this.game = new Game();
        this.game.addData(data);
        
    }
    
    public int getRoundsTimesHitpoints(ArrayList<String> data){
        this.parse(data);
        this.game.printBoard();
        return 0;
        
    }
    
}
