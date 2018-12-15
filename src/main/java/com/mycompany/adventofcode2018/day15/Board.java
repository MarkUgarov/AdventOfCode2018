/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.adventofcode2018.day15;

import com.mycompany.adventofcode2018.day15.figures.Figure;
import com.mycompany.adventofcode2018.day15.figures.creatures.Creature;
import com.mycompany.adventofcode2018.day15.figures.creatures.Elv;
import com.mycompany.adventofcode2018.day15.figures.creatures.Goblin;
import com.mycompany.adventofcode2018.day15.figures.terrains.Cavern;
import com.mycompany.adventofcode2018.day15.figures.terrains.Wall;
import java.util.ArrayList;

/**
 *
 * @author mark2d2
 */
public class Board {

    private int xDim;
    private int yDim;
    private Figure[][] cave;
    private final ArrayList<Creature> elves;
    private final ArrayList<Creature> goblins;
    
    
    public Board(){
        this.elves = new ArrayList<>();
        this.goblins = new ArrayList<>();
    }
    
    public void addData(ArrayList<String> data){
        this.xDim = data.get(0).length();
        this.yDim = data.size();
        this.cave = new Figure[this.xDim][this.yDim];
        int x = 0; 
        int y = 0;
        Figure curr;
        for (String d:data){
            for(char c:d.toCharArray()){
                curr = this.getNewFigure(c, x, y);
                this.cave[x][y] = curr;
                x++;
            }
            x=0;
            y++;
        }
    }

    private Figure getNewFigure(char descriptor, int xCoor, int yCoor){
        if(descriptor == ConstantPool.CHAR_ELV){
            Elv ret = new Elv(xCoor, yCoor);
            this.elves.add(ret);
            return ret;
        }
        else if (descriptor == ConstantPool.CHAR_GOBLIN){
            Goblin ret = new Goblin(xCoor, yCoor);
            this.goblins.add(ret);
            return ret;
        }
        else if (descriptor == ConstantPool.CHAR_WALL){
            return new Wall(xCoor, yCoor);
        }
        else if (descriptor == ConstantPool.CHAR_CAVERN){
            return new Cavern(xCoor, yCoor);
        }
        else{
            return null;
        }
    }
    
    public Figure[][] getCave(){
        return this.cave;
    }
    
    public boolean gameOver(){
        return this.elves.size() != 0 && this.goblins.size() != 0;
    }
    
    public void print(){
        for(int y = 0; y < cave[0].length; y++){
            for(int x = 0; x<cave.length; x++){
                System.out.print(cave[x][y].getDescriptor());
            }
            System.out.println();
        }
    }
    
}
