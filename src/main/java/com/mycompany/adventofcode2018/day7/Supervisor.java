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
public class Supervisor {
    
    private final Worker[] workers;
    private int time;
    private ArrayList<Node> remainingTasks;
    
    public Supervisor(int numberOfWorkers){
        this.workers = new Worker[numberOfWorkers];
        for(int i = 0; i<this.workers.length; i++){
            this.workers[i] = new Worker(""+i);
        }
        this.time = 0;
    }
    
    public void work(ArrayList<Node> tasks){
        this.remainingTasks = tasks;
        Node nextTask;
        boolean anyOneWorking = true;
        boolean workersAvailable;
        while(this.remainingTasks.size() > 0 && anyOneWorking){
            this.tick();
            workersAvailable = true;
            for(int i=0; i<this.remainingTasks.size() && workersAvailable; i++){ 
                nextTask = this.remainingTasks.get(i);
                if (nextTask.isAvailble() && !nextTask.inProgress()){
                    workersAvailable = this.deligate(nextTask);
                }
                // do nothing if not doable
                
            }
            
            anyOneWorking = this.workInProgress();
            
        }
        
    }
    
    private boolean deligate(Node task){
        boolean deligated = false;
        Worker currentWorker;
        for (int i = 0; i<this.workers.length && !deligated; i++){
            currentWorker = this.workers[i];
            if (!currentWorker.isWorking()){
                currentWorker.setTask(task);
                deligated = true;
            }
        }
        return deligated;
    }
    
    private boolean workInProgress(){
        boolean working = false;
        for(Worker w:this.workers){
            working = working || w.isWorking(); // &= is binary and &&= doesn't exist
        }
        return working;
    }
    
    private void tick(){
        boolean wasWorking;
        boolean workWasDone = false;
//        System.out.println("___________");
//        System.out.println("Tick "+ this.time);
        for(Worker w: this.workers){
//            if(w.isWorking()){
//                System.out.println("Worker "+w.getName()+": Task "+w.getCurrentTask().getName());
//            }
            wasWorking = w.isWorking();
            w.tick();
            if (!w.isWorking() && wasWorking){
                this.remainingTasks.remove(w.getLastTask()); // last Task won't be null because he was working
            }
            workWasDone = workWasDone || wasWorking;
        }
        if(workWasDone){
            this.time++;
            //System.out.println("Tick increased");
        }
    }
    
    public int getTimeWorked() {
        return this.time;
    }
    
    
}
