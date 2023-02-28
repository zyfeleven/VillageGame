package Inhabitant;

public class Archer implements Inhabitant{

    private int production;
    private int dmg;

    //constructor
    public Archer(){
        this.dmg = 10 + (int) Math.random()*5;
        this.production = 1 + (int) Math.random()*3;
    }

    public int getProduction(){
        return this.production;
    }

    public int getDmg(){
        return this.dmg;
    }
    public String getName(){
        return "Archer";
    }

}
