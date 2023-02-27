package Building;

import Inhabitant.Inhabitant;

import java.util.ArrayList;
import java.util.HashSet;

public class Cannons implements Defence{
    //constructor
    private int level;
    private int curArmies;
    private int maxArmies;
    private int hitpoint;
    private HashSet<Inhabitant> armires;
    private int dmg;

    public Cannons(){
        this.curArmies = 0;
        this.maxArmies = 5;
        this.level = 1;
        this.hitpoint = 150;
        this.dmg = 20;
        this.armires = new HashSet<>();
    }

    public void upgrade() {
        this.level++;
        this.dmg+=20;
        this.hitpoint+=100;
        this.maxArmies*=2;
    }

    public int getLevel(){
        return this.level;
    }

    public void addArmy(Inhabitant army){
        this.armires.add(army);
        this.curArmies++;
        this.dmg+=army.getDmg();
    }

    public int getDmg(){
        return this.dmg;
    }

    public String getName(){
        return "Cannons";
    }
}
