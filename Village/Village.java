package Village;
import Building.*;
import Data.Data;
import Data.Requirement;

import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

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
    private final Data data = new Data();
    private VillageRecord record;

    public Village(){
        this.buildings = new HashMap<>();
        this.buildings.put(new int[]{0,0,0}, new VillageHall());
        this.maxGold = 10000.0;
        this.maxIron = 10000.0;
        this.maxWood = 10000.0;
        this.maxPopulation = 10;
        this.ironProduction = 0.0;
        this.woodProduction = 0.0;
        this.goldProduction = 0.0;
        this.resource = new Resource(10,10,10);
        this.record = new VillageRecord();
        this.population = new Population();
        this.villageMap = new Vmap();
    }

    //add resources
    public void addResource(double gold,double wood,double iron){
        this.resource.changeResource(gold,wood,iron);
    }

    //reduce resources
    public void subResource(double gold,double wood,double iron){
        this.resource.changeResource(-gold,-wood,-iron);
    }

    //check if this village can build a specific building
    public boolean addBuilding(Building building, int[] position){
        if(this.villageMap.addBuilding(building,position)){
            if(this.resource.compareTo(this.data.getBuildingCost(building.getName(),1))){
                this.record.add(building.getName());
                this.buildings.put(position, building);
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
                }
            };
            return true;
        }
        else{
            return false;
        }
    }

    public boolean upgradeBuilding(int[] position , Timer timer){

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

                        //todo:
                    }
                }

                return true;
            }
        }
        else{
            if(comparator.canUpgrade() && this.resource.compareTo(data.getBuildingCost(name,level))){
                this.record.upgrade(name,level);
                this.buildings.get(position).upgrade();
                return true;
            }
        }
        return false;

    }

    public int getScore(){
        return this.record.getScore();
    }

    public double[] getProduction(){
        return new double[]{this.goldProduction, this.woodProduction, this.ironProduction};
    }
}
