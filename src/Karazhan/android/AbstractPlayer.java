/*
 * Classe abstraite pour le personnage.
 */

package Karazhan.android;

import android.app.Activity;

public abstract class AbstractPlayer extends Creature {
    protected Activity activity;
    protected Room CurrentRoom;
    protected Room LastRoom;

    //getter and setter
    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public Room getCurrentRoom() {
        return CurrentRoom;
    }

    public void setCurrentRoom(Room CurrentRoom) {
        this.CurrentRoom = CurrentRoom;
    }

    public Room getLastRoom() {
        return LastRoom;
    }

    public void setLastRoom(Room LastRoom) {
        this.LastRoom = LastRoom;
    }

    //other function
    public void setRoom(Room room) {
        if (this.CurrentRoom != null) {
            this.LastRoom = this.CurrentRoom;
        }
        this.CurrentRoom = room;
    }
}
//  To add
/*
    public void fightAgainst(CreatureInterface creature) {
        //request fight url
        //give the room url with monsters
    }
    
    public void flee()
    {
        Room tmp;
        this.LastRoom.loadRoom();
        tmp = this.CurrentRoom;
        this.CurrentRoom = this.LastRoom;
        this.LastRoom = tmp;
    }
*/