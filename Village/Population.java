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
    private ArrayList<Inhabitant> working;
    private ArrayList<Inhabitant> armies;
    //constructor
    Population(){
        this.workers = new ArrayList<>();
        this.miners = new ArrayList<>();
        this.catapults = new ArrayList<>();
        this.archers = new ArrayList<>();
        this.knights = new ArrayList<>();
        this.soldiers = new ArrayList<>();
        this.working = new ArrayList<>();
        this.armies = new ArrayList<>();
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
        else if(name.equals("Working")){
            return this.working;
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
        sum += this.working.size();
        sum+= this.armies.size();
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

    public void subPopulation(String name){

    }

    public void addArmies(Inhabitant inhabitant){
        this.armies.add(inhabitant);
    }
}
