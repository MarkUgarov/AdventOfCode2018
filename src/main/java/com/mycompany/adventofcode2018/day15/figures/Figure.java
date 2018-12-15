/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.adventofcode2018.day15.figures;

import com.mycompany.adventofcode2018.day15.Game;

/**
 *
 * @author mark2d2
 */
public interface Figure {
    
    /**
     * @return a descriptive Character (like 'E' for Elves, '.' for Cavern etc.)
     */
    public char getDescriptor();
    
    /**
     * @return true if the Figure is passable (Cavern), else false 
     */
    public boolean isPassable();
    
    /**
     * @return the current hitpoints
     */
    public int getCurrentHitpoints();
    
    /**
     * @return the attackdamage
     */
    public int getAttackDamage();
    
    /**
     * @param damage will be removed from current Hitpoints if Unit is "alive" 
     * (Elves and Goblins), otherwise nothing will be done to the unit (Cavern 
     * and Wall)
     */
    public void hurt(int damage);
    
    /**
     * @return 0 for walls and Caverns, 1 for Elvs, 2 for Goblins
     */
    public int getTeam();
    
    /**
     * @param f any Figure 
     * @return true if f is not in the same team and neither of them is in Team 0
     */
    public boolean isEnememy(Figure f);
    
    /**
     * kills the unit if it's killable
     */
    public void kill();
    
    
    /**
     * sets the Coordinates which are stored in the Object
     */
    public void setCoordinates(int x, int y);
    
    /**
     * @return the Coordinates which are stored in the Object
     */
    public Coordinates getCoordinates();
  
    
}
