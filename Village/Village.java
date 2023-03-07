package Village;
import Building.*;
import Data.Data;
import Data.Requirement;
import Inhabitant.*;

import java.util.*;

public class Village {
    //building map, when build a new building, give each building a unique bid and position that store in hashmap
    private HashMap<int[], Building> buildings;
    private double maxGold;
    private double maxWood;
    private double maxIron;
    //resource of the village(gold/wood/iron)
    private Resource resource;
    //the map of village
    private Vmap villageMap;
    private int maxPopulation;
    //population of the village(all inhabitants)
    private Population population;
    private double ironProduction;
    private double woodProduction;
    private double goldProduction;
    private double foodProduction;
    private final Data data = new Data();
    private VillageRecord record;

    public Village(){
        this.buildings = new HashMap<>();
        this.buildings.put(new int[]{0,0,0}, new VillageHall());
        this.maxGold = 10000.0;
        this.maxIron = 10000.0;
        this.maxWood = 10000.0;
        this.maxPopulation = 10;
        this.ironProduction = 5.0;
        this.woodProduction = 5.0;
        this.goldProduction = 5.0;
        this.foodProduction = 0.0;
        this.resource = new Resource(100,100,100);
        this.record = new VillageRecord();
        this.population = new Population();
        this.villageMap = new Vmap();
    }

    //add resources
    public void addResource(double gold,double wood,double iron){
        this.resource.addResource(gold,wood,iron,this.maxGold,this.maxWood,this.maxIron);
    }

    //reduce resources
    public void subResource(Resource resource){
        double gold = resource.getGold();
        double wood = resource.getWood();
        double iron = resource.getIron();
        this.resource.addResource(-gold,-wood,-iron,this.maxGold,this.maxWood,this.maxIron);
    }

    //check if this village can build a specific building
    public boolean addBuilding(Building building, int[] position,Timer timer, Worker worker){
        if(this.villageMap.addBuilding(building,position)){
            if(this.resource.compareTo(this.data.getBuildingCost(building.getName(),1))){
                TimerTask task = new TimerTask() {
                    @Override
                    public void run() {
                        record.add(building.getName());
                        buildings.put(position, building);
                        System.out.println(""+building.getName()+" construction completed");
                        worker.work(new int[]{-1,-1});
                    }
                };
                int timeCost = this.data.getTimeCost(building.getName(),1)*1000;
                worker.work(position);
                timer.schedule(task,timeCost);
                this.subResource(this.data.getBuildingCost(building.getName(),1));
                return true;
            }
            else{
                System.err.println("Resource is not enough!");
                return false;
            }
        }
        else return false;
    }

    public boolean addInhabitant(String name, Timer timer){
        if(this.population.getPopulationSize()==this.maxPopulation){
            return false;
        }
        if(this.resource.compareTo(this.data.getInhabitantCost(name))){
            TimerTask task = new TimerTask() {
                @Override
                public void run() {
                    population.addPopulation(name);
                    System.out.println("One "+name+" has been trained");
                }
            };
            int timeCost = this.data.getTimeCost(name,0)*1000;
            timer.schedule(task,timeCost);
            return true;
        }
        else{
            return false;
        }
    }



    public boolean upgradeBuilding(int[] position , Timer timer, Worker worker){
        if(worker.isArmy()||worker.workPosition()[0]!=-1||worker.workPosition()[1]!=-1){
            return false;
        }
        String name = this.buildings.get(position).getName();
        int level = this.buildings.get(position).getLevel();

        class ReqComparator {
            public boolean canUpgrade(){
                return false;
            }
        }
        //anonymous class
        ReqComparator comparator = new ReqComparator(){
            Requirement req = data.getVReq(level);
            VillageRecord record = Village.this.record;
            String[] buildings = new String[]{"VillageHall", "Farm", "IronMine", "GoldMine", "LumberHill", "Cannons", "ArcherTower"};

            public boolean canUpgrade(){
                if(req.getVillageHall()>record.getVillageHall()){
                    return false;
                }
                for(String name: buildings){
                    for(int i = 2;i>0;i--){
                        if(record.getRecord(name)[i]<req.getRecord(name)[i]){
                            System.out.println("Requirement is not met");
                            return false;
                        }
                        else if(record.getRecord(name)[i]>req.getRecord(name)[i]){
                            break;
                        }
                    }
                }
                return true;
            }
        };
        if(level == 3){
            System.err.println("This building has reached max level!");
            return false;
        }
        if(!name.equals("VillageHall")){
            if(level<this.record.getVillageHall() && this.resource.compareTo(data.getBuildingCost(name,level))){
                TimerTask task = new TimerTask() {
                    @Override
                    public void run() {
                        record.upgrade(name,level);
                        buildings.get(position).upgrade();
                        worker.work(new int[]{-1,-1});
                        calculateProduction();
                        //todo: calculate the defence score again
                    }
                };
                int timeCost = this.data.getTimeCost(name,level+1)*1000;
                worker.work(position);
                timer.schedule(task,timeCost);
                return true;
            }
        }
        else{
            if(comparator.canUpgrade() && this.resource.compareTo(data.getBuildingCost(name,level))){
                TimerTask task = new TimerTask() {
                    @Override
                    public void run() {
                        record.upgrade(name,level);
                        buildings.get(position).upgrade();
                        worker.work(new int[]{-1,-1});
                    }
                };
                int timeCost = this.data.getTimeCost(name,level+1)*1000;
                worker.work(position);
                timer.schedule(task,timeCost);
                return true;
            }
        }
        return false;
    }

    public void moveBuilding(int[] position, int[] target){
        Building b = this.buildings.get(position);
        if(this.villageMap.moveBuilding(b,position,target)){
            this.buildings.remove(position);
            this.buildings.put(target,b);
        }
    }

    public void removeBuilding(int[] position){
        this.villageMap.removeBuilding(position);
        this.buildings.get(position).remove();
        this.buildings.remove(position);
        this.calculateProduction();
    }


    public ArrayList<? extends Inhabitant> getInhabitants(String name){
        return this.population.getDetails(name);
    }

    public void addWorkersToBuilding(int index,String name,int[] position){
        this.population.addWorking(name,index,position);
        this.buildings.get(position).addWorker(this.population.getInhabitant(name,index));
        this.calculateProduction();
    }

    public void removeWorkerFromBuilding(String name, int index){
        int[] position = this.population.getInhabitant(name,index).workPosition();
        this.population.getInhabitant(name,index).work(new int[]{-1,-1});
        this.buildings.get(position).removeWorker(this.population.getInhabitant(name,index));

    }

    public void removeWorker(String name, int index){
        int[] position = this.population.getInhabitant(name,index).workPosition();
        this.population.getInhabitant(name,index).work(new int[]{-1,-1});
        this.buildings.get(position).removeWorker(this.population.getInhabitant(name,index));
        this.population.removePopulation(name,index);
    }

    public void removeArmy(int index){
        this.population.removeArmies(index);
    }

    public void removeArmy(String name, int index){
        this.population.removeArmies(name, index);
    }

    public void addWorking(String name, int index,int[] position){
        this.population.addWorking(name,index,position);
    }


    public void addArmies(int index, String name){
        this.population.addArmies(name,index);
    }

    public void calculateProduction(){
        double foodProduction = 0.0;
        double woodProduction = 0.0;
        double ironProduction = 0.0;
        double goldProduction = 0.0;
        for(Map.Entry<int[],Building> entry: this.buildings.entrySet()){
            Building building = entry.getValue();
            if(building.getName().equals("Farm")){
                foodProduction += building.getProduction();
            }
            else if(building.getName().equals("GoldMine")){
                goldProduction += building.getProduction();
            }
            else if(building.getName().equals("LumberHill")){
                woodProduction += building.getProduction();
            }
            else if(building.getName().equals("IronMine")){
                ironProduction += building.getProduction();
            }
        }
        this.foodProduction = foodProduction;
        this.ironProduction = ironProduction;
        this.woodProduction = woodProduction;
        this.goldProduction = goldProduction;
        this.maxPopulation = 10 + (int)foodProduction/10;
    }

    public Building getBuilding(int[] position){
        return this.buildings.get(position);
    }

    public HashMap<int[], Building> getBuildings(){
        return this.buildings;
    }

    public int getScore(){
        return this.record.getScore();
    }

    public double[] getProduction(){
        return new double[]{this.goldProduction, this.woodProduction, this.ironProduction, this.foodProduction};
    }

    public void printDetails(){

        System.out.println("----------");
        System.out.println("Current population: "+this.population.getPopulationSize()+"/"+this.maxPopulation);
        System.out.println("Number of buildings:"+this.buildings.size());
        System.out.println("Attack score: ");
        System.out.println("Defence score: ");
        System.out.println("Develop score: "+this.getScore());
        System.out.print("Current resource:");
        this.resource.print();
        System.out.print("Current production: ");
        System.out.print("Gold: "+this.goldProduction+" Iron: "+this.ironProduction+" Wood: "+this.woodProduction+" Food: "+this.foodProduction);
        System.out.println();
    }

    public void printMap(){
        this.villageMap.printMap();
    }


}
