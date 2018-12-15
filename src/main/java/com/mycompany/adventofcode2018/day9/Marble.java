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
public class Marble implements CircleElement{
    private final int value;
    private final boolean isMultipleOf23;
            
    
    public Marble(int value){
        this.value = value;
        this.isMultipleOf23 = (value != 0 && value%23 == 0);
    }
    
    public boolean isMultipleOf23(){      
        return this.isMultipleOf23;
    }

    @Override
    public int getScore() {
        return this.value;
    }
            
}
