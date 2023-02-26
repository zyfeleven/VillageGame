package Building;

import Inhabitant.Miner;

public class Mine implements Building{
    private int curWorker;
    private int maxWorker;
    private int level;
    private int[] position;
    private int hitpoint;

    Mine(){}

    public void upgrade() {

    }

    public int getLevel(){
        return this.level;
    }

    public void addMiner(Miner miner) {
    }

    public String getName(){
        return "Mine";
    }
}
