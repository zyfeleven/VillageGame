package Village;

//a data structure for recording village's population
public class Population {
    private int workers;
    private int miners;
    private int archers;
    private int knights;
    private int catapults;
    private int soldiers;

    //constructor
    Population(){
        this.workers = 0;
        this.miners= 0;
        this.archers = 0;
        this.knights = 0;
        this.catapults = 0;
        this.soldiers = 0;
        //initialize or read from file
    }

    public void changeWorkers(int num){
        this.workers+=num;
    }

    public void changeMiners(int num){
        this.miners+=num;
    }

    public void changeArchers(int num){
        this.archers+=num;
    }

    public void changeCatapults(int num){
        this.catapults+=num;
    }

    public void changeSoldiers(int num){
        this.soldiers+=num;
    }

    public void changeKnights(int num){
        this.knights+=num;
    }

    public int getWorkers(){
        return this.workers;
    }

    public int getMiners(){
        return this.miners;
    }

    public int getArchers(){
        return this.archers;
    }

    public int getCatapults(){
        return this.catapults;
    }

    public int getSoldiers(){
        return this.soldiers;
    }

    public int getKnights(){
        return this.knights;
    }

    //return the population size
    public int getPopulationSize(){
        return this.archers+this.knights+this.soldiers+this.catapults+this.workers+this.miners;
    }
}
