package Building;

import Inhabitant.Inhabitant;

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

    default double getProduction(){
        //default is return 0 (for villageHall and defence buildings)
        return 0;
    }

    default double getDmg(){
        //default is return 0 for non-defence buildings
        return 0;
    }
}
