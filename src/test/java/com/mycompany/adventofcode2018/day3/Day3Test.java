/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.adventofcode2018.day3;

import com.mycompany.adventofcode2018.day3.Day3;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mark2d2
 */
public class Day3Test {
    
    public Day3Test() {
    }

  
    /**
     * Test of getNumberOfOverlappedSquareInches method, of class Day3.
     */
    @Test
    public void testGetNumberOfOverlappedSquareInches() {
        System.out.println("getNumberOfOverlappedSquareInches");
        ArrayList<String> data = new ArrayList<>();
        data.add("#1 @ 1,3: 4x4");
        data.add("#2 @ 3,1: 4x4");
        data.add("#3 @ 5,5: 2x2");
        Day3 instance = new Day3();
        int expResult = 4;
        int result = instance.getNumberOfOverlappedSquareInches(data);
        assertEquals(expResult, result);
    }

    
}
