/*
 * 
*/

package Karazhan.android;

import android.widget.AbsListView;
import android.widget.Button;
import org.w3c.dom.NamedNodeMap;

public class AbstractDoor {

    protected Button door;
    protected Room room;
    protected String name;
    protected Player player;
    protected NamedNodeMap DoorNNM;
    protected AbsListView.LayoutParams bp;

    //Getter and Setter
    public Button getDoor() {
        return door;
    }

    public void setDoor(Button door) {
        this.door = door;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public NamedNodeMap getDoor_nnm() {
        return DoorNNM;
    }

    public void setDoor_nnm(NamedNodeMap DoorNNM) {
        this.DoorNNM = DoorNNM;
    }

    public AbsListView.LayoutParams getBp() {
        return bp;
    }

    public void setBp(AbsListView.LayoutParams bp) {
        this.bp = bp;
    }

    //other function
    protected void viewDoor() {
        //Try set image
        //Catch set text
    }

    protected void clickDoor() {
    }
}