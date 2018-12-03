/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.adventofcode2018.Day3;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mark2d2
 */
public class RectangleTest {
    
    public RectangleTest() {
    }

    /**
     * Test of print method, of class Rectangle.
     */
    @Test
    public void testPrint() {
        System.out.println("print");
        Rectangle instance = new Rectangle("#123 @ 3,2: 5x4");
        String expResult = "123: 3,2 = 5x4";
        String result = instance.print();
        assertEquals(expResult, result);
    }

    
    
}
