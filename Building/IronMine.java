package Building;

import Inhabitant.Inhabitant;
import Inhabitant.Miner;

import java.util.ArrayList;
import java.util.HashSet;

public class IronMine implements Mine {
    //constructor
    private int curWorker;
    private int maxWorker;
    private int level;
    private int hitpoint;
    private HashSet<Inhabitant> miners;
    private int production;
    //constructor
    public IronMine(){
        this.curWorker = 0;
        this.maxWorker = 5;
        this.level = 1;
        this.hitpoint = 100;
        this.production = 0;
        this.miners = new HashSet<>();
    }

    public void upgrade(){
        this.level++;
        this.maxWorker*=2;
        this.hitpoint+=100;
        this.production+=20;
    }

    public int getLevel(){
        return this.level;
    }

    public void addMiner(Inhabitant miner) {
        this.miners.add(miner);
        this.production+=miner.getProduction();
        this.curWorker++;
    }
    public int getCurWorker(){
        return this.curWorker;
    }
    public String getName(){
        return "IronMine";
    }
}
