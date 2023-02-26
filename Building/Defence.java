package Building;

import Inhabitant.Inhabitant;

import java.util.ArrayList;

public class Defence implements Building{
    protected int level;
    protected int[] position;
    protected ArrayList<Inhabitant> armies;
    protected int curArmies;
    protected int maxArmies;
    protected int hitpoint;

    Defence(){}

    public void upgrade() {
        this.level++;
    }

    public int getLevel(){
        return this.level;
    }

    public void addArmy(Inhabitant army){

    }

    public String getName(){
        return "Defence";
    }
}
