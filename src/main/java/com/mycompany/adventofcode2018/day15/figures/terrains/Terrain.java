/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.adventofcode2018.day15.figures.terrains;

import com.mycompany.adventofcode2018.day15.figures.Coordinates;
import com.mycompany.adventofcode2018.day15.figures.Figure;

/**
 *
 * @author mark2d2
 */
public class Terrain implements Figure{

    private final boolean passable;
    private final char descriptor;
    private Coordinates coordinates;
    
    public Terrain(boolean isPassable, char descriptor, int xCoor, int yCoor){
        this.passable = isPassable;
        this.descriptor = descriptor;
        this.coordinates = new Coordinates(xCoor, yCoor);
    }
    
    @Override
    public char getDescriptor() {
        return this.descriptor;
    }

    @Override
    public boolean isPassable() {
        return this.passable;
    }

    @Override
    public int getCurrentHitpoints() {
        // this should not be called
        return Integer.MAX_VALUE;
    }

    @Override
    public void hurt(int damage) {
        // this should not be called
    }

    @Override
    public int getTeam() {
        return 0;
    }

    @Override
    public boolean isEnememy(Figure f) {
        return false;
    }

    @Override
    public void kill() {
        // this should not be called
    }

    @Override
    public int getAttackDamage() {
        return 0;
    }

    @Override
    public void setCoordinates(int x, int y) {
        this.coordinates.set(x, y);
    }

    @Override
    public Coordinates getCoordinates() {
        return this.coordinates;
    }
    
}
