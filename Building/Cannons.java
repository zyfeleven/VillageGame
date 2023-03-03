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
    private HashSet<Inhabitant> armies;
    private double dmg;

    public Cannons(){
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
    public void removeWorker(Inhabitant worker){
        this.armies.remove(worker);
        worker.work(new int[]{0,0});
        this.dmg -= worker.getDmg();
    }

    public double getDmg(){
        return this.dmg;
    }

    public String getName(){
        return "Cannons";
    }

    public HashSet<Inhabitant> getWorkers(){
        return this.armies;
    }
}
