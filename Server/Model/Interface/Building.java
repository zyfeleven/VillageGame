package Server.Model.Interface;

import java.util.HashSet;

public interface Building {
    void upgrade();
    //upgrade the building

    int getLevel();
    //return building level

    String getName();
    //return building's name

    default void addWorker(Inhabitant worker){
        //default is doing nothing(VillageHall can't add worker in)
    }

    default void removeWorker(Inhabitant worker){
        //default is doing nothing(VillageHall can't add worker in)
    }

    //return this building's production
    default double getProduction(){
        //default is return 0 (for villageHall and defence buildings)
        return 0;
    }

    default double getDmg(){
        //default is return 0 for non-defence buildings
        return 0;
    }

    //return an integer array filled with curWorker and maxWorker
    default int[] getCurWorker(){
        return null;
    }

    //return workers in this building
    default HashSet<Inhabitant> getWorkers(){
        return null;
    }

    //remove this building(remove all workers from this building)
    void remove();

    default double getHp(){return 1000.0;}
}
