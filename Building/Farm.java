package Building;

import Inhabitant.Inhabitant;

import java.util.HashSet;

public class Farm implements Building{
    private int curWorker;
    private int maxWorker;
    private int level;
    private int hitpoint;
    private double production;
    private HashSet<Inhabitant> workers;

    //descriptions of methods are in Building interface
    //constructor
    public Farm(){
        this.curWorker = 0;
        this.maxWorker = 5;
        this.level = 1;
        this.hitpoint = 100;
        this.production = 5;
        this.workers = new HashSet<>();
    }

    //implement methods in interface Building
    public void upgrade() {
        this.level++;
        this.maxWorker*=2;
        this.hitpoint+=100;
    }

    public int getLevel(){
        return this.level;
    }

    public void addWorker(Inhabitant worker) {
        this.workers.add(worker);
        this.production+=worker.getProduction();
        this.curWorker++;
    }

    public void removeWorker(Inhabitant worker){
        this.workers.remove(worker);
        worker.work(new int[]{0,0});
        this.production -= worker.getProduction();
    }

    public double getProduction(){
        return this.production;
    }
    public String getName(){
        return "Farm";
    }
    public HashSet<Inhabitant> getWorkers(){
        return this.workers;
    }

    public int[] getCurWorker(){
        return new int[]{this.curWorker,this.maxWorker};
    }

    public void remove(){
        for(Inhabitant i: workers){
            i.work(new int[]{-1,-1});
        }
    }
}
