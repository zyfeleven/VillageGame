package Inhabitant;

public class Catapult implements Inhabitant{

    //constructor
    private double production;
    private double dmg;
    //constructor
    public Catapult(){
        this.dmg = 10.0 +  Math.random()*5;
        this.production = 1.0 +  Math.random()*3;
    }

    //implementation
    public String getName(){
        return "Catapult";
    }

    public double getProduction(){
        return this.production;
    }

    public double getDmg(){
        return this.dmg;
    }

}
