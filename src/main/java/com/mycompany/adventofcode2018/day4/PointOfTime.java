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
public class PointOfTime implements Comparable<PointOfTime>{
    private final Date date;
    private final String message;
    
    public PointOfTime(String line){
        this.date = this.parseDate(line);
        this.message = this.parseMessage(line);
    }
    
    private Date parseDate(String line){
        String dateString = this.find("(?<=\\[)([^\\]]+)(?=\\])", line);
        SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        try {
            return parser.parse(dateString);
        } catch (ParseException ex) {
            Logger.getLogger(Tools.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    private String parseMessage(String line){
        return this.find("(?<=\\])(.*)", line);
    }
    
    public String getDateString(){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return formatter.format(this.date);
    }
    
    public Date getDate(){
        return this.date;
    }
    
    public String getMessage(){
        return this.message;
    }
    
    public String describedGuard(){
        return this.find("(?<=#)([^\\s]+)(?=\\W)", this.message);
    }
    
    private String find(String regex, String content){
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(content);
        if(m.find()){
            return m.group();
        }
        else{
            return null;
        }
    }
    

    @Override
    public int compareTo(PointOfTime o) {
        Date d1 = this.date;
        Date d2 = o.date;
        if (d1.before(d2)) {
                return -1;
            } else if (d1.after(d2)) {
                return 1;
            } else {
                return 0;
            }
    }
    
    
    
}
