package Server.Model.Factory;

import Server.Model.Building.*;
import Server.Model.Interface.Building;

public class BuildingFactory {
    Building building;
    public BuildingFactory(){}
    public Building retBuilding(int index){
        if(index == 1){
            building = new Farm();
        }
        else if(index == 2){
            building = new GoldMine();
        }
        else if(index == 3){
            building = new IronMine();
        }
        else if(index == 4){
            building = new LumberHill();
        }
        else if(index == 5){
            building = new ArcherTower();
        }
        else if(index == 6){
            building = new Cannons();
        }
        return building;
    }
}
