package Inhabitant;

public class Worker implements Inhabitant{
    //constructor
    private double production;
    private double dmg;

    //constructor
    public Worker(){
        this.dmg = 5.0;
        this.production = 1.0 + Math.random()*3;
    }

    public double getProduction(){
        return this.production;
    }

    public double getDmg(){
        return this.dmg;
    }
    public String getName(){
        return "Worker";
    }
}
