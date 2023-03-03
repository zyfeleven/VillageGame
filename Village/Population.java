package Village;

import Inhabitant.*;

import java.util.ArrayList;
import java.util.HashMap;

//a data structure for recording village's population
public class Population {
    private ArrayList<Worker> workers;
    private ArrayList<Miner> miners;
    private ArrayList<Archer> archers;
    private ArrayList<Knight> knights;
    private ArrayList<Catapult> catapults;
    private ArrayList<Soldier> soldiers;
    private ArrayList<Inhabitant> armies;
    //constructor
    Population(){
        this.workers = new ArrayList<>();
        this.miners = new ArrayList<>();
        this.catapults = new ArrayList<>();
        this.archers = new ArrayList<>();
        this.knights = new ArrayList<>();
        this.soldiers = new ArrayList<>();
        this.armies = new ArrayList<>();
    }

    public Inhabitant getInhabitant(String name, int index){
        if(name.equals("Worker")){
            return this.workers.get(index);
        }
        else if(name.equals("Miner")){
            return this.miners.get(index);
        }
        else if(name.equals("Catapult")){
            return this.catapults.get(index);
        }
        else if(name.equals("Soldiers")){
            return this.soldiers.get(index);
        }
        else if(name.equals("Knight")){
            return this.knights.get(index);
        }
        else if(name.equals("Armies")){
            return this.armies.get(index);
        }
        else{
            return this.archers.get(index);
        }
    }

    public ArrayList<?> getDetails(String name){
        if(name.equals("Worker")){
            return this.workers;
        }
        else if(name.equals("Miner")){
            return this.miners;
        }
        else if(name.equals("Catapult")){
            return this.catapults;
        }
        else if(name.equals("Soldiers")){
            return this.soldiers;
        }
        else if(name.equals("Knight")){
            return this.knights;
        }
        else if(name.equals("Armies")){
            return this.armies;
        }
        else{
            return this.archers;
        }
    }

    //return the population size
    public int getPopulationSize(){
        int sum = 0;
        sum += this.workers.size();
        sum += this.catapults.size();
        sum += this.miners.size();
        sum += this.knights.size();
        sum += this.archers.size();
        sum += this.soldiers.size();
        return sum;
    }

    public void addPopulation(String name){
        if(name.equals("Worker")){
            this.workers.add(new Worker());
        }
        else if(name.equals("Miner")){
            this.miners.add(new Miner());
        }
        else if(name.equals("Catapult")){
            this.catapults.add(new Catapult());
        }
        else if(name.equals("Soldiers")){
            this.soldiers.add(new Soldier());
        }
        else if(name.equals("Knight")){
            this.knights.add(new Knight());
        }
        else{
            this.archers.add(new Archer());
        }
    }

    public void removePopulation(String name, int index){
        if(name.equals("Worker")){
            this.workers.remove(index);
        }
        else if(name.equals("Miner")){
            this.miners.remove(index);
        }
        else if(name.equals("Catapult")){
            this.catapults.remove(index);
        }
        else if(name.equals("Soldiers")){
            this.soldiers.remove(index);
        }
        else if(name.equals("Knight")){
            this.knights.remove(index);
        }
        else{
            this.archers.remove(index);
        }
    }

    public void addArmies(String name, int index){
        if(name.equals("Worker")){
            this.armies.add(this.workers.get(index));
        }
        else if(name.equals("Miner")){
            this.armies.add(this.miners.get(index));
        }
        else if(name.equals("Catapult")){
            this.armies.add(this.catapults.get(index));
        }
        else if(name.equals("Soldiers")){
            this.armies.add(this.soldiers.get(index));
        }
        else if(name.equals("Knight")){
            this.armies.add(this.knights.get(index));
        }
        else{
            this.armies.add(this.archers.get(index));
        }
    }

    public void addWorking(String name, int index,int[] position){
        if(name.equals("Worker")){
            this.workers.get(index).work(position);
        }
        else if(name.equals("Miner")){
            this.miners.get(index).work(position);
        }
        else if(name.equals("Catapult")){
            this.catapults.get(index).work(position);
        }
        else if(name.equals("Soldiers")){
            this.soldiers.get(index).work(position);
        }
        else if(name.equals("Knight")){
            this.knights.get(index).work(position);
        }
        else{
            this.archers.get(index).work(position);
        }
    }

    public void removeArmies(int index){
        this.armies.remove(index);
    }
}
