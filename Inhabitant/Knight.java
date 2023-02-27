package Inhabitant;

public class Knight implements Inhabitant{

    //constructor
    private int production;
    private int dmg;
    //constructor
    public Knight(){
        this.production = 2 + (int) Math.random()*5;
        this.dmg = 5;
    }

    //implementation
    public String getName(){
        return "Knight";
    }

    public int getProduction(){
        return this.production;
    }

    public int getDmg(){
        return this.dmg;
    }
}
