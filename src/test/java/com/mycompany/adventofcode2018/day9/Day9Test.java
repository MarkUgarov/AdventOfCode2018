/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.adventofcode2018.day9;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mark2d2
 */
public class Day9Test {
    
    public Day9Test() {
    }

    /**
     * Test of getHighScore method, of class Day9.
     */
    @Test
    public void testGetHighScore() {
        System.out.println("getHighScore");
        ArrayList<String> data = new ArrayList<>();
        data.add("10 players; last marble is worth 23 points");
        Day9 instance = new Day9();
        int expResult = 32;
        int result = instance.getHighScore(data);
        assertEquals(expResult, result);
        
//        data.set(0, "10 players; last marble is worth 1618 points");
//        expResult = 8317;
//        assertEquals(expResult, result);
        
//        data.set(0, "13 players; last marble is worth 7999 points");
//        expResult = 146373;
//        assertEquals(expResult, result);
//        
//        data.set(0, "17 players; last marble is worth 1104 points");
//        expResult = 2764;
//        assertEquals(expResult, result);
//        
//        data.set(0, "21 players; last marble is worth 6111");
//        expResult = 54718;
//        assertEquals(expResult, result);
//        
//        data.set(0, "30 players; last marble is worth 5807 points");
//        expResult = 37305;
//        assertEquals(expResult, result);    
        
    }
    
}
