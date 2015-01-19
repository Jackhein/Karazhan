/*
 * 
*/

package Karazhan.android;

public abstract class Creature implements CreatureInterface {
    private int life;
    private int speed;
    private int pp;
    private String name;
    private String type;
    
    public void addLife(int hp) {
        life =+ hp;
    }

    public void removeLife(int hp) {
        life =- hp;
    }

    public boolean isDead() {
        if (life <= 0)
            return true;
        return false;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getPp() {
        return pp;
    }

    public void setPp(int pp) {
        this.pp = pp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}