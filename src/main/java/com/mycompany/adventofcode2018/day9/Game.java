/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.adventofcode2018.day9;

import java.util.ArrayList;

/**
 *
 * @author mark2d2
 */
public class Game {
    private Circle<Player> players;
    private Player currentPlayer;
    
    private Circle<Marble> marbles;
      
    public Game(int numberOfPlayers){
        this.players = new Circle<>();
        this.marbles = new Circle<>();
        for (int i = 0; i<numberOfPlayers; i++){
            this.players.addElement(new Player(i));
        }   
        
        
    }
    
    public void simulate(int steps){
        Marble currentMarble;
        
        for (int currentStep = 0; currentStep<steps; currentStep++){
            this.players.setCurrentElementIndex(currentStep);
            this.currentPlayer = this.players.getCurrentElement();
            currentMarble = new Marble(currentStep);
            if(currentMarble.isMultipleOf23()){
                this.currentPlayer.addToScore(currentMarble.getScore());
                this.marbles.setCurrentElementIndex(currentStep-7);
                currentMarble = this.marbles.getCurrentElement();
                this.currentPlayer.addToScore(currentMarble.getScore());
                this.marbles.deleteElement(currentStep-7);
                
            }
            else{
                this.marbles.setCurrentElementIndex(this.marbles.getCurrentElementIndex()+1);
                this.marbles.addElement(this.marbles.getCurrentElementIndex(), currentMarble);
            }
            
            
        }
        this.println();
    }
    
    private void println(){
        int i =0;
        for (Marble m:this.marbles.getContent()){
            System.out.print(""+i+"|");
            if (m.equals(this.marbles.getCurrentElement())){
                System.out.print("("+m.getScore()+")");
            }
            else{
                System.out.print(" "+m.getScore()+" ");
            }
            i++;
            System.out.println();
        }
    }
    
    public int getMaxPlayerScore(){
        int maxScore = 0;
        ArrayList<Player> content = this.players.getContent();
        for (Player e:content){
            maxScore = (maxScore> e.getScore())? maxScore:e.getScore();
        }
        return maxScore;
    }
   
}
