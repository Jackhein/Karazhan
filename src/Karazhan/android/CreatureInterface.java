/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Karazhan.android;

/**
 *
 * @author 42
 */
public interface CreatureInterface {
    public void addLife(int hp);
    
    public void removeLife(int hp);
    
    public boolean isDead();
    
}