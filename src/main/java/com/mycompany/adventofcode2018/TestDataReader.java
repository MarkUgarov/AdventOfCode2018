/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.adventofcode2018;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *
 * @author mark2d2
 */
public class TestDataReader {
    
    public static ArrayList<String> getTestData(String filePath) throws IOException{
        ArrayList<String> ret = new ArrayList<>();
        BufferedReader in = new BufferedReader(new FileReader(filePath));
        String inputLine;
        int number;
        while ((inputLine = in.readLine()) != null){
            ret.add(inputLine);
           // System.out.println(inputLine);
        }
        
        in.close();
        return ret;
        
    }
    
    public static ArrayList<Integer> getTestDataAsInteger(String filePath) throws IOException{
        ArrayList<String> data = getTestData(filePath);
        ArrayList<Integer> ret = new ArrayList<>();
        int val = 0;
        for (String d:data){
            if(d != null && d.length() > 0){
                try {
                    val = Integer.parseInt(d);
                    ret.add(val);
                    } 
                catch (NumberFormatException e) {
                    // do nothing
                    }
                 
            }
        }
        return ret;
        
    }
    
    
}
