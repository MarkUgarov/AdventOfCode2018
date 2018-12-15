/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.adventofcode2018.day15;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mark2d2
 */
public class Day15Test {
    
    public Day15Test() {
    }

   

    /**
     * Test of getRoundsTimesHitpoints method, of class Day15.
     */
    @Test
    public void testGetRoundsTimesHitpoints() {
        System.out.println("getRoundsTimesHitpoints");
        ArrayList<String> data = new ArrayList<>();
        data.add("#######");
        data.add("#.G...#");
        data.add("#...EG#");
        data.add("#.#.#G#");
        data.add("#..G#E#");
        data.add("#.....#");
        data.add("#######");
        Day15 instance = new Day15();
        int expResult = 27730;
        int result = instance.getRoundsTimesHitpoints(data);
        assertEquals(expResult, result);
    }
    
}
