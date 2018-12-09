/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.adventofcode2018.day7;

import java.util.ArrayList;

/**
 *
 * @author mark2d2
 */
public class Node implements Comparable<Node>{
    
    private final String name;
    private final ArrayList<Node> prevenientNodes;
    private final ArrayList<Node> subsequentNodes;
    private int timeRequired;
    private boolean inProgress;
    
    private boolean done;
    
    public Node(String name){
        this.name = name;
        this.prevenientNodes = new ArrayList<>();
        this.subsequentNodes = new ArrayList<>();
        this.done = false;
        this.timeRequired = this.getNumForChar(this.name.charAt(0))+60;
        this.inProgress = false;
//        System.out.println("Node "+ name + " has been created.");

    }
    
    public void addPrevenientNode(Node node){
        this.prevenientNodes.add(node);
    }
    
    public void addSubsequentNode(Node node){
        this.subsequentNodes.add(node);
    }
    
    public ArrayList<Node> getPrevenientNodes(){
        return this.prevenientNodes;
    }
    
    public ArrayList<Node> getsubsequentNodes(){
        return this.subsequentNodes;
    }

    @Override
    public int compareTo(Node o) {
        return this.name.compareTo(o.name);
    }
    
    public String getName(){
        return this.name;
    }
    
    public void setDone(){
        this.done = true;
    }
    
    public void setUndone(){
        this.done = false;
    }
    
    public boolean isDone(){
        return this.done;
    }
         
    public int getTimeRequired(){
        return this.timeRequired;
    }
    
    public boolean inProgress(){
        return this.inProgress;
    }
    
    public void setInProgress(boolean status){
        this.inProgress = status;
    }
        
    public boolean isAvailble(){
        boolean doable = true;
        Node n;
        for (int i = 0; i<this.prevenientNodes.size() && doable; i++) {
            n = this.prevenientNodes.get(i);
            doable = doable && n.isDone();
//            if (doable){
//                System.out.print(n.getName() + " is done ||");
//            }
//            else{
//                System.out.print(n.getName()+ " is not done || ");
//            }
            //System.out.print(n.getName() +" is "+ ((n.isDone())?"done":"not Done || "));
        }
//        System.out.println("Result for "+this.name +" : "+ ((doable)?"available":"not Available"));
        
        return doable;
    }
    
    private int getNumForChar(char c){
        int val = "abcdefghijklmnopqrstuvwxyz".indexOf(Character.toLowerCase(c))+1;
        if (val <0){
            System.out.println (c+" not found, returning 26 ");
            return 27;
        }
        return val;
    }
}
