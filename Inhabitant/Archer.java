package Inhabitant;

public class Archer implements Inhabitant{

    private double production;
    private double dmg;

    //constructor
    public Archer(){
        this.dmg = 10.0 + Math.random()*5;
        this.production = 1.0 + Math.random()*3;
    }

    public double getProduction(){
        return this.production;
    }

    public double getDmg(){
        return this.dmg;
    }
    public String getName(){
        return "Archer";
    }

}
