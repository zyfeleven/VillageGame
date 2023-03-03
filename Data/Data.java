package Data;

import Building.Building;
import Inhabitant.Inhabitant;
import Village.Resource;

import java.util.HashMap;

public class Data {
    //instances that store the cost data
    //Resource[] : [level1 cost, level2 cost...]
    public final int[] villageHallTimeCost = new int[]{10,60,120};
    public final Resource[] villageHallCost = new Resource[] {new Resource(100,100,100), new Resource(500,500,500), new Resource(3000,3000,3000)};
    public final Requirement VReq1 = new Requirement(0,new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0});
    public final Requirement VReq2 = new Requirement(1,new int[]{3,0,0},new int[]{3,0,0},new int[]{3,0,0},new int[]{3,0,0},new int[]{1,0,0},new int[]{1,0,0});
    public final Requirement VReq3 = new Requirement(2,new int[]{0,3,0},new int[]{0,3,0},new int[]{0,3,0},new int[]{0,3,0},new int[]{0,1,0},new int[]{0,1,0});
    public final Requirement[] villageHallReq = new Requirement[] {VReq1,VReq2,VReq3};

    public final int[] farmTimeCost = new int[]{5,15,45};
    public final Resource[] farmCost = new Resource[] {new Resource(50,50,50), new Resource(150,150,150), new Resource(500,500,500)};

    public final int[] mineTimeCost = new int[]{5,15,45};
    public final Resource[] goldMineCost = new Resource[] {new Resource(0,100,50), new Resource(0,300,150), new Resource(0,1000,500)};
    public final Resource[] ironMineCost = new Resource[] {new Resource(100,50,0), new Resource(300,150,0), new Resource(1000,500,0)};
    public final Resource[] lumberHillCost = new Resource[] {new Resource(50,0,100), new Resource(150,0,300), new Resource(500,0,1000)};

    public final int[] defenceTimeCost = new int[]{10,25,60};
    public final Resource[] archerTowerCost = new Resource[] {new Resource(100,100,100), new Resource(300,300,300), new Resource(1000,1000,1000)};
    public final Resource[] cannonCost = new Resource[] {new Resource(100,100,100), new Resource(300,300,300), new Resource(1000,1000,1000)};

    public final int workerTimeCost = 3;
    public final Resource workerCost = new Resource(10,10,10);

    public final int minerTimeCost = 3;
    public final Resource minerCost = new Resource(10,10,10);

    public final int armyTimeCost = 6;
    public final Resource archerCost = new Resource(50,50,50);
    public final Resource catapultCost = new Resource(50,100,30);
    public final Resource knightCost = new Resource(100,50,40);
    public final Resource soldierCost = new Resource(70,30,90);


    //constructor: read data.json and store all constants in class members
    public Data(){

    }

    public Requirement getVReq(int level){
        if(level == 1){
            return this.VReq1;
        }
        else if(level == 2){
            return this.VReq2;
        }
        else return this.VReq3;
    }

    public Resource getBuildingCost(String name, int level){
        if(name.equals("VillageHall")){
            return this.villageHallCost[level-1];
        }
        else if(name.equals("Farm")){
            return this.farmCost[level-1];
        }
        else if(name.equals("ArcherTower")){
            return this.archerTowerCost[level-1];
        }
        else if(name.equals("Cannons")){
            return this.cannonCost[level-1];
        }
        else if(name.equals("GoldMine")){
            return this.goldMineCost[level-1];
        }
        else if(name.equals("IronMine")){
            return this.ironMineCost[level-1];
        }
        else{
            return this.lumberHillCost[level-1];
        }
    }

    public Resource getInhabitantCost(String name){
        if(name.equals("Worker")){
            return this.workerCost;
        }
        else if(name.equals("Miner")){
            return this.minerCost;
        }
        else if(name.equals("Archer")){
            return this.archerCost;
        }
        else if(name.equals("Knight")){
            return this.knightCost;
        }
        else if(name.equals("Soldier")){
            return this.soldierCost;
        }
        else{
            return this.catapultCost;
        }
    }

    public int getTimeCost(String name, int level){
        if(level == 0){
            if(name.equals("Worker")){
                return this.workerTimeCost;
            }
            else if(name.equals("Miner")){
                return this.minerTimeCost;
            }
            else {
                return this.armyTimeCost;
            }
        }
        else{
            if(name.equals("VillageHall")){
                return this.villageHallTimeCost[level-1];
            }
            else if(name.equals("Farm")){
                return this.farmTimeCost[level-1];
            }
            else if(name.equals("ArcherTower")||name.equals("Cannons")){
                return this.defenceTimeCost[level-1];
            }
            else {
                return this.mineTimeCost[level-1];
            }
        }
    }

}
