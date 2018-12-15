/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.adventofcode2018.day15.figures;

/**
 *
 * @author mark2d2
 */
public class PathFinder {
    
    private final Figure[][] cave;
    private int[][] distances;
    
    public PathFinder(Figure[][] cave){
        this.cave = cave;
        
    }
    
    public int getMinimalDistantCoordinates(Figure f1, Figure f2){
        this.distances = new int[this.cave.length][this.cave[0].length];
        for (int i = 0; i<this.distances.length; i++){
            for (int j = 0; j<this.distances[0].length; j++){
                this.distances[i][j] = -1;
            }
        }
        int ret = this.getMinimalDistantCoordinates(f1.getCoordinates(), f2.getCoordinates());
        this.print();
        return ret;
    }
    
    
    
    private int getMinimalDistantCoordinates(Coordinates c1, Coordinates c2){
        if (c1.getX() == c2.getX() && c1.getY() == c2.getY()){
            return 0;
        }
        else {
            this.fill(c1, c2);
            return this.distances[c1.getX()][c1.getY()];
        }
        
    }
    
    private Coordinates fill(Coordinates c1, Coordinates c2){
        if (c1 != null && c1.getX() == c2.getX() && c1.getY() == c2.getY()){
            this.distances[c1.getX()][c1.getY()] = 0;
            return c1;
        }
        Coordinates up = (c1.getX() > 0 )? null: new Coordinates(c1.getX(), c1.getY()-1);
        Coordinates left = (c1.getX() > 0)? null: new Coordinates(c1.getX()-1, c1.getY());
        Coordinates right = (c1.getX() < this.distances.length-1)? null: new Coordinates(c1.getX()+1, c1.getY());
        Coordinates down = (c1.getX() < this.distances[0].length-1)? null: new Coordinates(c1.getX(), c1.getY()-1);
        int upDistance, leftDistance, rightDistance, downDistance;
        
        upDistance = this.getValueAt(up, c2);
        leftDistance = this.getValueAt(left, c2);
        rightDistance = this.getValueAt(right, c2);
        downDistance = this.getValueAt(down, c2);
        
        Coordinates retCoords = up;
        int minDistance = upDistance;
        if (upDistance > leftDistance){
            retCoords = left;
            minDistance = leftDistance;
        }
        if (leftDistance > rightDistance){
            retCoords = right;
            minDistance = rightDistance;
        }
        if (rightDistance > downDistance){
            retCoords = down;
            minDistance = downDistance;
        }
        this.distances[c1.getX()][c1.getY()] = minDistance+1;
        return down;
        
        
    }
    
    private int getValueAt(Coordinates c1, Coordinates c2){
        int ret;
        if (c1 != null && this.getBoardAt(c1).isPassable()){
            if (this.distances[c1.getX()][c1.getY()] == -1){
                this.fill(c1, c2);
            }
            ret = this.distances[c1.getX()][c1.getY()];
        }
        else{
            ret = Integer.MAX_VALUE;
        }
        return ret;
    }
    
    private Figure getBoardAt(Coordinates c){
        return this.cave[c.getX()][c.getY()];
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
