/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.adventofcode2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mark2d2
 */
public class URLReader {
    private static URL url;
    
    public URLReader(String url){
        try {
            this.url  = new URL(url);
        } catch (MalformedURLException ex) {
            Logger.getLogger(URLReader.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("No URL was found.");
        }
        
       
        
    }
    
    public ArrayList<Integer> readContent() throws IOException{
        if (this.url == null){
            return null;
        }
        ArrayList<Integer> ret = new ArrayList<>();
        BufferedReader in;
        in = new BufferedReader(
                new InputStreamReader(url.openStream()));
      
        System.out.println("URL Stream opened");

        String inputLine;
        int number;
        while ((inputLine = in.readLine()) != null){
            number = Integer.parseInt(inputLine);
            ret.add(number);
            System.out.println(number);
        }
        
        in.close();
        
        return ret;
    }
    
   
}
