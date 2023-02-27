package Inhabitant;

public class Worker implements Inhabitant{
    //constructor
    private int production;
    private int dmg;

    //constructor
    public Worker(){
        this.dmg = 5;
        this.production = 1 + (int) Math.random()*3;
    }

    public int getProduction(){
        return this.production;
    }

    public int getDmg(){
        return this.dmg;
    }
    public String getName(){
        return "Worker";
    }
}
