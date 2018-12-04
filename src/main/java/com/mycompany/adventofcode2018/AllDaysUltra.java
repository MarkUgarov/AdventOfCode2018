/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.adventofcode2018;

import com.mycompany.adventofcode2018.day3.Day3;
import com.mycompany.adventofcode2018.day1.Day1;
import com.mycompany.adventofcode2018.day2.Day2;

/**
 *
 * @author mark2d2
 */
public class AllDaysUltra {
    
    public AllDaysUltra(){
        Day1 day1 = new Day1();
        day1.printResults();
        Day2 day2 = new Day2();
        day2.printResults();
        Day3 day3 = new Day3();
        day3.printResults();
        
        System.exit(0);
    }
    
}
