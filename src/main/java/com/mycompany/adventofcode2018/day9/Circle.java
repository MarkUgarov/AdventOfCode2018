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
public class Circle<Element> {
    
    
    private ArrayList<Element> elements;
    private int currentElementIndex;
    
    public Circle(){
        this.elements = new ArrayList<>();
        this.currentElementIndex = 0;
    }
    
    public int getNumberOfElements(){
        return this.elements.size();
    }
    
    public Element getElementForStep(int stepNumber){
        int index = this.calcIndex(stepNumber);
        return this.elements.get(index);
    }
    
    public void addElement(Element element){
        this.elements.add(element);
        this.currentElementIndex = this.elements.size()-1;
    }
    
    public void addElement(int step, Element element){
        int index = this.calcIndex(step);
        if (index > this.elements.size()){
            this.elements.add(element);
        }
        else{
            this.elements.add(index, element);
            
        }
        System.out.println("Added: element on index " +index);
    }
    
    public void deleteElement(int step){
        System.out.println("Remove: "+this.calcIndex(step));
        this.elements.remove(this.calcIndex(step));
    }
    
    public Element getCurrentElement(){
        return this.elements.get(currentElementIndex);
    }
    
    public void setCurrentElementIndex(int stepNumber){
        this.currentElementIndex = this.calcIndex(stepNumber);
    }
    
    public int getCurrentElementIndex(){
        return this.currentElementIndex;
    }
    
    public ArrayList<Element> getContent(){
        return this.elements;
    }
    
    private int calcIndex(int stepNumber){
        int index = 0;
        if (stepNumber != 0){
             Math.abs((this.getNumberOfElements()%stepNumber)-1);
        }
        return index;
    }
   
}
