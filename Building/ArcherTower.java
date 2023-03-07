package Building;

import Inhabitant.Inhabitant;

import java.util.HashSet;

public class ArcherTower implements Defence{
    private int level;
    private int curArmies;
    private int maxArmies;
    private int hitpoint;
    private HashSet<Inhabitant> armies;
    private double dmg;

    //descriptions of methods are in Building interface
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
    public void removeWorker(Inhabitant worker){
        this.armies.remove(worker);
        worker.work(new int[]{0,0});
        this.dmg-=worker.getDmg();
    }

    public double getDmg(){
        return this.dmg;
    }

    public String getName(){
        return "ArcherTower";
    }

    public HashSet<Inhabitant> getWorkers(){
        return this.armies;
    }

    public int[] getCurWorker(){
        return new int[]{this.curArmies,this.maxArmies};
    }

    public void remove(){
        for(Inhabitant i: armies){
            i.work(new int[]{-1,-1});
        }
    }
}
