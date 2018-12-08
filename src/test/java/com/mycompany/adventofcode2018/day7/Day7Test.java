/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.adventofcode2018.day7;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mark2d2
 */
public class Day7Test {
    
    public Day7Test() {
    }

   
    /**
     * Test of getOrder method, of class Day7.
     */
    @Test
    public void testGetOrder() {
        System.out.println("getOrder");
        ArrayList<String> data = new ArrayList<>();
        data.add("Step B must be finished before step E can begin.");
        data.add("Step D must be finished before step E can begin.");
       
        data.add("Step A must be finished before step B can begin.");
        data.add("Step A must be finished before step D can begin.");
        data.add("Step C must be finished before step A can begin.");
        data.add("Step C must be finished before step F can begin.");
        data.add("Step F must be finished before step E can begin.");
        Day7 instance = new Day7();
        String expResult = "CABDFE";
        String result = instance.getOrder(data);
        assertEquals(expResult, result);
    }
    
}
