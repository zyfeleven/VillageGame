package Server.Model.Inhabitant;

import Server.Model.Interface.Inhabitant;

public class Knight implements Inhabitant {

    //constructor
    private double production;
    private double dmg;
    private int[] workIn;
    private boolean isArmy;
    //constructor
    public Knight(){
        this.dmg = 10.0 + Math.random()*5;
        this.production = 1.0 + Math.random()*3;
        this.workIn = new int[] {-1,-1};
        this.isArmy = false;
    }

    //implementation
    public String getName(){
        return "Knight";
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
    public double getHp(){
        return 100.0;
    }
}
