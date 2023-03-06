package Inhabitant;

public class Miner implements Inhabitant{
    private double production;
    private double dmg;
    private int[] workIn;
    private boolean isArmy;
    //constructor
    public Miner(){
        this.production = 2.0 + Math.random()*5;
        this.dmg = 5.0;
        this.workIn = new int[] {-1,-1};
        this.isArmy = false;
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
    public int[] workPosition(){return this.workIn;}
    public void work(int[] position){
        this.workIn = position;
    }
    public boolean isArmy(){
        return this.isArmy;
    }
    public void isArmy(boolean b){
        this.isArmy = b;
    }

}
