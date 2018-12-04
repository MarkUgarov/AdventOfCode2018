/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.adventofcode2018.day4;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mark2d2
 */
public class Day4Test {
    
    public Day4Test() {
    }

   
    /**
     * Test of getGuardWithMostSleep method, of class Day4.
     */
    @Test
    public void testGetGuardWithMostSleep() {
        System.out.println("getGuardWithMostSleep");
        ArrayList<String> data = new ArrayList<>();
        Day4 instance = new Day4();
        data.add("[1518-11-01 00:00] Guard #10 begins shift");
        data.add("[1518-11-01 00:05] falls asleep");
        data.add("[1518-11-01 00:25] wakes up");
        data.add("[1518-11-01 00:30] falls asleep");
        data.add("[1518-11-01 00:55] wakes up");
        data.add("[1518-11-01 23:58] Guard #99 begins shift");
        data.add("[1518-11-02 00:40] falls asleep");
        data.add("[1518-11-02 00:50] wakes up");
        data.add("[1518-11-03 00:05] Guard #10 begins shift");
        data.add("[1518-11-03 00:24] falls asleep");
        data.add("[1518-11-03 00:29] wakes up");
        data.add("[1518-11-04 00:02] Guard #99 begins shift");
        data.add("[1518-11-04 00:36] falls asleep");
        data.add("[1518-11-04 00:46] wakes up");
        data.add("[1518-11-05 00:03] Guard #99 begins shift");
        data.add("[1518-11-05 00:45] falls asleep");
        data.add("[1518-11-05 00:55] wakes up");
        
        String expResult = "10";
        String result = instance.getGuardWithMostSleep(data).getId();
        assertEquals(expResult, result);
    }



    /**
     * Test of getProductOfIdAndSleepAmount method, of class Day4.
     */
    @Test
    public void testGetProductOfIdAndSleepAmount() {
        System.out.println("getProductOfIdAndSleepAmount");
        ArrayList<String> data = new ArrayList<>();
        data.add("[1518-11-01 00:00] Guard #10 begins shift");
        data.add("[1518-11-01 00:05] falls asleep");
        data.add("[1518-11-01 00:25] wakes up");
        data.add("[1518-11-01 00:30] falls asleep");
        data.add("[1518-11-01 00:55] wakes up");
        data.add("[1518-11-01 23:58] Guard #99 begins shift");
        data.add("[1518-11-02 00:40] falls asleep");
        data.add("[1518-11-02 00:50] wakes up");
        data.add("[1518-11-03 00:05] Guard #10 begins shift");
        data.add("[1518-11-03 00:24] falls asleep");
        data.add("[1518-11-03 00:29] wakes up");
        data.add("[1518-11-04 00:02] Guard #99 begins shift");
        data.add("[1518-11-04 00:36] falls asleep");
        data.add("[1518-11-04 00:46] wakes up");
        data.add("[1518-11-05 00:03] Guard #99 begins shift");
        data.add("[1518-11-05 00:45] falls asleep");
        data.add("[1518-11-05 00:55] wakes up");
        Day4 instance = new Day4();
        int expResult = 240;
        int result = instance.getProductOfIdAndMaxSleepMinute(data);
        assertEquals(expResult, result);
    }

    

    /**
     * Test of getProductOfIdAndMaxSleepMinute method, of class Day4.
     */
    @Test
    public void testGetProductOfIdAndMaxSleepMinute() {
        System.out.println("getProductOfIdAndMaxSleepMinute");
        ArrayList<String> data = new ArrayList<>();
        data.add("[1518-11-01 00:00] Guard #10 begins shift");
        data.add("[1518-11-01 00:05] falls asleep");
        data.add("[1518-11-01 00:25] wakes up");
        data.add("[1518-11-01 00:30] falls asleep");
        data.add("[1518-11-01 00:55] wakes up");
        data.add("[1518-11-01 23:58] Guard #99 begins shift");
        data.add("[1518-11-02 00:40] falls asleep");
        data.add("[1518-11-02 00:50] wakes up");
        data.add("[1518-11-03 00:05] Guard #10 begins shift");
        data.add("[1518-11-03 00:24] falls asleep");
        data.add("[1518-11-03 00:29] wakes up");
        data.add("[1518-11-04 00:02] Guard #99 begins shift");
        data.add("[1518-11-04 00:36] falls asleep");
        data.add("[1518-11-04 00:46] wakes up");
        data.add("[1518-11-05 00:03] Guard #99 begins shift");
        data.add("[1518-11-05 00:45] falls asleep");
        data.add("[1518-11-05 00:55] wakes up");
        Day4 instance = new Day4();
        int expResult = 240;
        int result = instance.getProductOfIdAndMaxSleepMinute(data);
        assertEquals(expResult, result);
    }

    /**
     * Test of getProductOfIdAndValueOfMaxSleepMinute method, of class Day4.
     */
    @Test
    public void testGetProductOfIdAndValueOfMaxSleepMinute() {
        System.out.println("getProductOfIdAndValueOfMaxSleepMinute");
        ArrayList<String> data = new ArrayList<>();
        data.add("[1518-11-01 00:00] Guard #10 begins shift");
        data.add("[1518-11-01 00:05] falls asleep");
        data.add("[1518-11-01 00:25] wakes up");
        data.add("[1518-11-01 00:30] falls asleep");
        data.add("[1518-11-01 00:55] wakes up");
        data.add("[1518-11-01 23:58] Guard #99 begins shift");
        data.add("[1518-11-02 00:40] falls asleep");
        data.add("[1518-11-02 00:50] wakes up");
        data.add("[1518-11-03 00:05] Guard #10 begins shift");
        data.add("[1518-11-03 00:24] falls asleep");
        data.add("[1518-11-03 00:29] wakes up");
        data.add("[1518-11-04 00:02] Guard #99 begins shift");
        data.add("[1518-11-04 00:36] falls asleep");
        data.add("[1518-11-04 00:46] wakes up");
        data.add("[1518-11-05 00:03] Guard #99 begins shift");
        data.add("[1518-11-05 00:45] falls asleep");
        data.add("[1518-11-05 00:55] wakes up");
        Day4 instance = new Day4();
        int expResult = 4455;
        int result = instance.getProductOfIdAndValueOfMaxSleepMinute(data);
        assertEquals(expResult, result);
    }
    
}
