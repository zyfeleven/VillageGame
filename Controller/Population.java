package Controller;

import Model.Inhabitant.*;
import Model.Interface.Inhabitant;

import java.util.ArrayList;

//a data structure for recording village's population
public class Population {
    //arraylists for inhabitants
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

    //return a specific inhabitant searched by the name and index
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

    //return one arraylist of a specific type of inhabitants
    public ArrayList<? extends Inhabitant> getDetails(String name){
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

    //add a particular type of inhabitant
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

    //remove one specific inhabitant
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

    //add one inhabitant to the army
    public void addArmies(String name, int index){
        if(name.equals("Worker")){
            this.armies.add(this.workers.get(index));
            this.workers.get(index).isArmy(true);
        }
        else if(name.equals("Miner")){
            this.armies.add(this.miners.get(index));
            this.miners.get(index).isArmy(true);
        }
        else if(name.equals("Catapult")){
            this.armies.add(this.catapults.get(index));
            this.catapults.get(index).isArmy(true);
        }
        else if(name.equals("Soldiers")){
            this.armies.add(this.soldiers.get(index));
            this.soldiers.get(index).isArmy(true);
        }
        else if(name.equals("Knight")){
            this.armies.add(this.knights.get(index));
            this.knights.get(index).isArmy(true);
        }
        else{
            this.armies.add(this.archers.get(index));
            this.archers.get(index).isArmy(true);
        }
    }

    //set one inhabitant to work at one position
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

    //remove one inhabitant from the army
    public void removeArmies(int index){
        this.armies.get(index).isArmy(false);
        this.armies.remove(index);
    }

    //remove one specific inhabitant from the army
    public void removeArmies(String name, int index){
        if(name.equals("Worker")){
            this.armies.remove(this.workers.get(index));
            this.workers.get(index).isArmy(false);
        }
        else if(name.equals("Miner")){
            this.armies.remove(this.miners.get(index));
            this.miners.get(index).isArmy(false);
        }
        else if(name.equals("Catapult")){
            this.armies.remove(this.catapults.get(index));
            this.catapults.get(index).isArmy(false);
        }
        else if(name.equals("Soldiers")){
            this.armies.remove(this.soldiers.get(index));
            this.soldiers.get(index).isArmy(false);
        }
        else if(name.equals("Knight")){
            this.armies.remove(this.knights.get(index));
            this.knights.get(index).isArmy(false);
        }
        else{
            this.armies.remove(this.archers.get(index));
            this.archers.get(index).isArmy(false);
        }
    }
}
