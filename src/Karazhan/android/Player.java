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
public class Player extends Creature{
    
    private RoomInterface curentRoom;
    private RoomInterface lastRoom;
    
    public void fightAgainst(CreatureInterface creature) {
        
        //request fight url
        //give the room url with monsters
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void flee()
    {
        RoomInterface tmp;
        this.lastRoom.loadRoom();
        tmp = this.curentRoom;
        this.curentRoom = this.lastRoom;
        this.lastRoom = tmp;
    }
    
}
