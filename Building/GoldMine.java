package Building;

import Inhabitant.Inhabitant;
import Inhabitant.Miner;

import java.util.ArrayList;
import java.util.HashSet;

public class GoldMine implements Mine {

    //constructor
    private int curWorker;
    private int maxWorker;
    private int level;
    private int hitpoint;
    private HashSet<Inhabitant> miners;
    private int production;
    //constructor
    public GoldMine(){
        this.curWorker = 0;
        this.maxWorker = 5;
        this.level = 1;
        this.hitpoint = 100;
        this.production = 5;
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

    public void addWorker(Inhabitant miner) {
        this.miners.add(miner);
        this.production+=miner.getProduction();
        this.curWorker++;
    }
    public void removeWorker(Inhabitant worker){
        this.miners.remove(worker);
        worker.work(new int[]{0,0});
        this.production -= worker.getProduction();
    }
    public int[] getCurWorker(){
        return new int[]{this.curWorker,this.maxWorker};
    }
    public String getName(){
        return "GoldMine";
    }
    public HashSet<Inhabitant> getWorkers(){
        return this.miners;
    }

    public void remove(){
        for(Inhabitant i: miners){
            i.work(new int[]{-1,-1});
        }
    }
}
