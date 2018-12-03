/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.adventofcode2018.day2;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mark2d2
 */
public class Day2Test {
    /**
     * Test of testGetCheckProduct method, of class Day2.
     */
    @Test
    public void testGetCheckProduct() {
        System.out.println("getChecksum");
        ArrayList<String> data = new ArrayList<>();
        data.add("abcdef");
        data.add("bababc");
        data.add("abbcde");
        data.add("abcccd");
        data.add("aabcdd");
        data.add("abcdee");
        data.add("ababab");
        Day2 instance = new Day2();
        int expResult = 12;
        int result = instance.getCheckProduct(data);
        assertEquals(expResult, result);
    }

    /**
     * Test of getAppearancesCounterForWord method, of class Day2.
     */
    @Test
    public void testGetAppearancesCounterForWord() {
        System.out.println("getAppearancesCounterForWord");
        String arg = "bababc";
        Day2 instance = new Day2();
        ArrayList<Integer> expResult = new ArrayList<>();
        expResult.add(0);
        expResult.add(1);
        expResult.add(1);
        expResult.add(1);
        ArrayList<Integer> result = instance.getAppearancesCounterForWord(arg);
        assertEquals(expResult, result);
    }

    /**
     * Test of getAppearancesForWord method, of class Day2.
     */
    @Test
    public void testGetAppearancesForWord() {
        System.out.println("getAppearancesForWord");
        String arg = "bababc";
        Day2 instance = new Day2();
        int[] expResult = new int[27];
        for (int i = 0; i<expResult.length; i++){
            expResult[i] = 0;
        }
        expResult[0] = 2;
        expResult[1] = 3;
        expResult[2] = 1;
        int[] result = instance.getAppearancesForWord(arg);
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of getMostCommon method, of class Day2.
     */
    @Test
    public void testGetMostCommon() {
        System.out.println("getMostCommon");
        ArrayList<String> data = new ArrayList<>();
        data.add("abcde");
        data.add("fghij");
        data.add("klmno");
        data.add("pqrst");
        data.add("fguij");
        data.add("axcye");
        data.add("wvxyz");
        Day2 instance = new Day2();
        String expResult = "fgij";
        String result = instance.getMostCommon(data);
        assertEquals(expResult, result);
    }

    
    
}
