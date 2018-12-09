/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.adventofcode2018.day7;

/**
 *
 * @author mark2d2
 */
public class Worker {
    
    private final String name;
    private int remainingTimeToWork;
    private Node currentTask;
    private Node lastTask;
    
    
    
    public Worker(String name){
        this.name = name;
        this.remainingTimeToWork = 0;
    }
    
    public void tick(){
        this.tick(1);
    }
    
    public void tick(int numberOfTicks){
        this.remainingTimeToWork = Math.max(0, this.remainingTimeToWork-numberOfTicks);
        if (this.remainingTimeToWork == 0 && this.currentTask != null){
            this.currentTask.setDone();
            this.currentTask.setInProgress(false);
            this.lastTask = this.currentTask;
            this.currentTask = null;
        }
    }
    
    public boolean isWorking(){
        return this.currentTask != null;
    }
    
    public void setTask(Node task){
        this.currentTask = task;
        this.currentTask.setInProgress(true);
        this.remainingTimeToWork = task.getTimeRequired();
    }
    
    public Node getCurrentTask(){
        return this.currentTask;
    }
    
    public Node getLastTask(){
        return this.lastTask;
    }
    
    public String getName(){
        return this.name;
    }
    
}
