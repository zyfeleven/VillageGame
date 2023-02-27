package Inhabitant;

public class Soldier implements Inhabitant{

    private int production;
    private int dmg;

    //constructor
    public Soldier(){
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
        return "Soldier";
    }
}
