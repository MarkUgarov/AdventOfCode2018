/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.adventofcode2018;

import com.mycompany.adventofcode2018.day3.Day3;
import com.mycompany.adventofcode2018.day1.Day1;
import com.mycompany.adventofcode2018.day2.Day2;
import com.mycompany.adventofcode2018.day4.Day4;
import com.mycompany.adventofcode2018.day5.Day5;
import com.mycompany.adventofcode2018.day6.Day6;
import com.mycompany.adventofcode2018.day7.Day7;

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
        Day4 day4 = new Day4();
        day4.printResults();
        Day5 day5 = new Day5();
        day5.printResults();
        Day6 day6 = new Day6();
        day6.printResults();
        Day7 day7 = new Day7();
        day7.printResults();
        System.exit(0);
    }
    
}
