package Inhabitant;

public class Miner implements Inhabitant{
    private int production;
    //constructor
    Miner(){}

    //implementation
    public String typeOf(){
        return "Miner";
    }

    public int getProduction(){
        return this.production;
    }

}
