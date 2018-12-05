/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.adventofcode2018.day5;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author black
 */
public class Day5Test {
    
    public Day5Test() {
    }


    /**
     * Test of applyReaction method, of class Day5.
     */
    @Test
    public void testApplyReaction() {
        System.out.println("applyReaction");
        ArrayList<String> data = new ArrayList<>();
        data.add("dabAcCaCBAcCcaDA");
        Day5 instance = new Day5();
        String expResult = "dabCBAcaDA";
        String result = instance.applyReaction(data);
        assertEquals(expResult, result);
        
        data = new ArrayList<>();
        data.add("aabAAB");
        expResult = "aabAAB";
        result = instance.applyReaction(data);
        assertEquals(expResult, result);
    }

    /**
     * Test of getLengthAfterReaction method, of class Day5.
     */
    @Test
    public void testGetLengthAfterReaction() {
        System.out.println("getLengthAfterReaction");
        ArrayList<String> data = new ArrayList<>();
        data.add("dabAcCaCBAcCcaDA");
        Day5 instance = new Day5();
        int expResult = 10;
        int result = instance.getLengthAfterReaction(data);
        assertEquals(expResult, result);
        
        data = new ArrayList<>();
        data.add("aabAAB");
        expResult = 6;
        result = instance.getLengthAfterReaction(data);
        assertEquals(expResult, result);
    }

    /**
     * Test of getMinLenghtByCleaningChars method, of class Day5.
     */
    @Test
    public void testGetMinLenghtByCleaningChars() {
        System.out.println("getMinLenghtByCleaningChars");
        ArrayList<String> data = new ArrayList<>();
        data.add("dabAcCaCBAcCcaDA");
        Day5 instance = new Day5();
        int expResult = 4;
        int result = instance.getMinLenghtByCleaningChars(data);
        assertEquals(expResult, result);
    }
    
}
