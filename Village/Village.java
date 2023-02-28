package Village;
import Building.*;
import java.util.HashMap;

public class Village {
    //building map, when build a new building, give each building a unique bid and position that store in hashmap
    private HashMap<Building, int[]> buildings;
    private int maxGold;
    private int maxWood;
    private int maxIron;
    //resource of the village(gold/wood/iron)
    private Resource resource;
    //the map of village
    private Vmap villageMap;
    private int maxPopulation;
    //population of the village(all inhabitants)
    private Population population;

    public Village(){
        this.buildings = new HashMap<>();
        this.buildings.put(new VillageHall(),new int[]{0,0,0});
        this.maxGold = 100;
        this.maxIron = 100;
        this.maxWood = 100;
        this.maxPopulation = 10;
        this.resource = new Resource(10,10,10);
        this.villageMap = new Vmap();
        this.population = new Population();
        this.villageMap = new Vmap();
    }

    //add resources
    public void addResource(int gold,int wood,int iron){
        this.resource.changeResource(gold,wood,iron);
    }

    //reduce resources
    public void subResource(int gold,int wood,int iron){
        this.resource.changeResource(-gold,-wood,-iron);
    }

    //check if this village can build/upgrade a specific building
    public boolean addBuilding(String buildingName, int level, int[] position){
        return true;
    }
}
