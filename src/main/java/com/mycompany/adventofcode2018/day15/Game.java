/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.adventofcode2018.day15;

import com.mycompany.adventofcode2018.day15.figures.terrains.Cavern;
import com.mycompany.adventofcode2018.day15.figures.creatures.Elv;
import com.mycompany.adventofcode2018.day15.figures.Figure;
import com.mycompany.adventofcode2018.day15.figures.creatures.Goblin;
import com.mycompany.adventofcode2018.day15.figures.terrains.Wall;
import java.util.ArrayList;

/**
 *
 * @author mark2d2
 */
public class Game {
    
    private int rounds;
    private Board board;
    private int xDim;
    private int yDim;
   
    
    public Game(){
        this.board = new Board();
        this.rounds = 0;
    }
    
    public void addData(ArrayList<String> data){
        this.board.addData(data);
    }
    
    
    
    public void play(){
        while(!this.board.gameOver()){
            this.rounds ++;
        }
    }
    
    public void printBoard(){
        this.board.print();
    }
}
