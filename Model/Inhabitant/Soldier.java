package Model.Inhabitant;

import Model.Interface.Inhabitant;

public class Soldier implements Inhabitant {

    private double production;
    private double dmg;
    private int[] workIn;
    private boolean isArmy;

    //constructor
    public Soldier(){
        this.dmg = 10.0 +  Math.random()*5;
        this.production = 1.0 +  Math.random()*3;
        this.workIn = new int[] {-1,-1};
        this.isArmy = false;
    }

    public double getProduction(){
        return this.production;
    }

    public double getDmg(){
        return this.dmg;
    }
    public String getName(){
        return "Soldier";
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

    public double getHp(){
        return 100.0;
    }
}
