package Inhabitant;

public class Miner implements Inhabitant{
    private int production;
    private int dmg;
    //constructor
    public Miner(){
        this.production = 2 + (int) Math.random()*5;
        this.dmg = 5;
    }

    //implementation
    public String getName(){
        return "Miner";
    }

    public int getProduction(){
        return this.production;
    }

    public int getDmg(){
        return this.dmg;
    }

}
