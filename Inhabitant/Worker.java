package Inhabitant;

public class Worker implements Inhabitant{
    //constructor
    private double production;
    private double dmg;
    private int[] workIn;

    //constructor
    public Worker(){
        this.dmg = 5.0;
        this.production = 1.0 + Math.random()*3;
        this.workIn = new int[] {0,0};
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
    public int[] workPosition(){return this.workIn;}
    public void work(int[] position){
        this.workIn = position;
    }
}
