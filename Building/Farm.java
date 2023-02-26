package Building;

public class Farm implements Building{
    private int curWorker;
    private int maxWorker;
    private int level;
    private int[] position;
    private int hitpoint;
    private int production;
    //constructor
    Farm(){}

    //implement methods in interface Building
    public void upgrade() {

    }

    public int getLevel(){
        return this.level;
    }

    public String getName(){
        return "Farm";
    }
}
