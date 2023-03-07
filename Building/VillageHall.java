package Building;

import Inhabitant.Inhabitant;

public class VillageHall implements Building {
    private int level;
    private int hitpoint;
    //constructor
    public VillageHall(){
        this.level = 1;
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

    public void remove(){
        System.out.println("You can't remove VillageHall");
    }

}
