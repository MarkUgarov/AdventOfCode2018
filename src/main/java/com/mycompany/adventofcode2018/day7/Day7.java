/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.adventofcode2018.day7;

import com.mycompany.adventofcode2018.Day;
import com.mycompany.adventofcode2018.TestDataReader;
import com.mycompany.adventofcode2018.day1.Day1;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mark2d2
 */
public class Day7 implements Day{
    
    private static final String FILE_PATH = "TestDataDay7";
    private ArrayList<String> testData;
    
    private ArrayList<Node> nodes;
    
    public Day7(){
        try {
            this.testData = TestDataReader.getTestData(FILE_PATH);
        } catch (IOException ex) {
            Logger.getLogger(Day1.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }
    }

    @Override
    public void printResults() {
        System.out.println("------------------------------------");
        System.out.println("DAY 7");
        System.out.println(this.getOrder(testData));
        System.out.println(this.getRequiredTime(testData, 4));
        System.out.println("------------------------------------");
        return;
    }
    
    private void parse(ArrayList<String> data){
        this.nodes = new ArrayList<>();
        Node currentPrev;
        Node currentSub;
        String currentPrevString = "";
        String currentSubString = "";
        for (String line: data){
            currentPrevString = ""+line.charAt(5);
            currentSubString = ""+line.charAt(36);
            currentPrev = this.getNode(currentPrevString);
            currentSub = this.getNode(currentSubString);
            currentPrev.addSubsequentNode(currentSub);
            currentSub.addPrevenientNode(currentPrev);
        }
        this.nodes.sort(null);
    }
    
    private Node getNode(String name){
        Node ret = null;
        Node current;
        for (int i = 0; i<this.nodes.size() && ret == null; i++){
            current = this.nodes.get(i);
            ret = (current.getName().equals( name))? current : null;
        }
        if (ret == null){
            ret = new Node(name);
            this.nodes.add(ret);
        }
        
        return ret;
    }
    
    private ArrayList<Node> getStartingNodes(){
        ArrayList<Node> ret = new ArrayList<>();
        for (Node n: this.nodes){
            if(n.getPrevenientNodes().size() == 0){
                ret.add(n);
            }
        }
        ret.sort(null);
        return ret;
    }
    
    private ArrayList<Node> generateNodeOrder(){
        boolean done = false;
        Node current;
        ArrayList<Node> nodeSeq = new ArrayList<>();
        while (!done) {
            done  = true;
            for (int i = 0; i<this.nodes.size() && done; i++){
                current = this.nodes.get(i);
                if(!current.isDone() && current.isAvailble() ){
                    nodeSeq.add(current);
                    current.setDone();
                    done = false;
                }
            }
        }
        return nodeSeq;
    }
    
    public String getOrder(ArrayList<String> data){
        this.parse(data);
        ArrayList<Node> nodeSeq = this.generateNodeOrder();
        StringBuilder sequence = new StringBuilder(); 
        for (Node n:nodeSeq){
            sequence.append(n.getName());
        }
        return sequence.toString();
    }
    
    public int getRequiredTime(ArrayList<String> data, int numberOfWorkers){
        this.parse(data);
        ArrayList<Node> nodeSeq = this.generateNodeOrder();
        for (Node n:nodeSeq){
            n.setUndone();
        }
        Supervisor supervisor = new Supervisor(numberOfWorkers);
        supervisor.work(nodeSeq);

        return supervisor.getTimeWorked();
    }
    
    
    
    
}
