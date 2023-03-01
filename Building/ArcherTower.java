package Building;

import Inhabitant.Inhabitant;

import java.util.ArrayList;
import java.util.HashSet;

public class ArcherTower implements Defence{
    private int level;
    private int curArmies;
    private int maxArmies;
    private int hitpoint;
    private HashSet<Inhabitant> armies;
    private int dmg;

    public ArcherTower(){
        this.curArmies = 0;
        this.maxArmies = 5;
        this.level = 1;
        this.hitpoint = 150;
        this.dmg = 20;
        this.armies = new HashSet<>();
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

    public void addWorker(Inhabitant army){
        this.armies.add(army);
        this.curArmies++;
        this.dmg+=army.getDmg();
    }

    public int getDmg(){
        return this.dmg;
    }

    public String getName(){
        return "ArcherTower";
    }

    public HashSet<Inhabitant> getWorkers(){
        return this.armies;
    }
}
