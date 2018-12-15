/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.adventofcode2018.day15.figures.terrains;

import com.mycompany.adventofcode2018.day15.ConstantPool;

/**
 *
 * @author mark2d2
 */
public class Cavern extends Terrain{
    
    public Cavern(int x, int y) {
        super(true, ConstantPool.CHAR_CAVERN,x,y);
    }
    
    
    
}
