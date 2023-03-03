package Building;

import Inhabitant.Inhabitant;

public class VillageHall implements Building {
    private int level;
    private int[] position;
    private int hitpoint;
    //constructor
    public VillageHall(){

    }

    //implement methods in interface Building
    public void upgrade() {
        this.level++;
    }

    public int getLevel(){
        return this.level;
    }

    public String getName(){
        return "Village";
    }

}
