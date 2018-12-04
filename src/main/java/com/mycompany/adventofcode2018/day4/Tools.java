/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.adventofcode2018.day4;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author mark2d2
 */
public final class Tools {
    
    public static Date getDate(String line){
        Pattern p = Pattern.compile("(?<=\\[)([^\\]]+)(?=\\])");
        Matcher m = p.matcher(line);
        m.find();
        String dateString = m.group();
        SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        try {
            return parser.parse(dateString);
        } catch (ParseException ex) {
            Logger.getLogger(Tools.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public static String getDateString(Date date){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return formatter.format(date);
    }
    
}
