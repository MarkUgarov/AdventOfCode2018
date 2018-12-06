/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.adventofcode2018.day6;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mark2d2
 */
public class Day6Test {
    
    public Day6Test() {
    }

   
    /**
     * Test of getBiggestArea method, of class Day6.
     */
    @Test
    public void testGetBiggestArea() {
        System.out.println("getBiggestArea");
        ArrayList<String> data = new ArrayList<>();
        data.add("1, 1");
        data.add("1, 6");
        data.add("8, 3");
        data.add("3, 4");
        data.add("5, 5");
        data.add("8, 9");
        Day6 instance = new Day6();
        int expResult = 17;
        int result = instance.getBiggestArea(data);
        assertEquals(expResult, result);
    }
    
}
