package Village;

//a data structure for recording user/village's resource : gold/wood/iron
public class Resource {
    private double gold;
    private double wood;
    private double iron;

    //constructor
    public Resource(double gold, double wood, double iron){
        this.gold = gold;
        this.wood = wood;
        this.iron = iron;
    }

    public void changeResource(double gold, double wood, double iron){
        this.gold += gold;
        this.wood += wood;
        this.iron += iron;
    }

    public double[] getResource(){
        return new double[]{gold,wood,iron};
    }

    public double getGold(){
        return this.gold;
    }

    public double getWood(){
        return this.wood;
    }

    public double getIron(){
        return this.iron;
    }

    public boolean compareTo(Resource resource){
        return this.gold>=resource.getGold() && this.wood>=resource.getWood() && this.iron>=resource.getWood();
    }
}
