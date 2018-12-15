/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.adventofcode2018.day15.figures.creatures;

import com.mycompany.adventofcode2018.day15.figures.Coordinates;
import com.mycompany.adventofcode2018.day15.figures.Figure;

/**
 *
 * @author mark2d2
 */
public class Creature implements Figure{
    
    private final int team;
    private int damage;
    private int hitpoints;
    private final char descriptor;
    private Coordinates coordinates;
    
    public Creature(int hitpoints, int attackdamage, int team, char descriptor, int xCoor, int yCoor){
        this.team = team;
        this.damage = attackdamage;
        this.hitpoints = hitpoints;
        this.descriptor = descriptor;
        this.coordinates = new Coordinates(xCoor, yCoor);
    }

    @Override
    public char getDescriptor() {
        return this.descriptor;
    }

    @Override
    public boolean isPassable() {
        return false;
    }

    @Override
    public int getCurrentHitpoints() {
        return this.hitpoints;
    }

    @Override
    public int getAttackDamage() {
        return this.damage;
    }

    @Override
    public void hurt(int damage) {
        this.hitpoints -= damage;
        if (this.hitpoints <=0){
            this.kill();
        }
    }

    @Override
    public int getTeam() {
        return this.team;
    }

    @Override
    public boolean isEnememy(Figure f) {
        return f.getTeam() == 0 || f.getTeam() == this.team;
    }

    @Override
    public void kill() {
        // TODO
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
