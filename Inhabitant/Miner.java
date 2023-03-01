package Inhabitant;

public class Miner implements Inhabitant{
    private double production;
    private double dmg;
    //constructor
    public Miner(){
        this.production = 2.0 + Math.random()*5;
        this.dmg = 5.0;
    }

    //implementation
    public String getName(){
        return "Miner";
    }

    public double getProduction(){
        return this.production;
    }

    public double getDmg(){
        return this.dmg;
    }

}
