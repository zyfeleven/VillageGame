package Village;

//a data structure for recording user/village's resource : gold/wood/iron
public class Resource {
    private int gold;
    private int wood;
    private int iron;

    //constructor
    public Resource(int gold, int wood, int iron){
        this.gold = gold;
        this.wood = wood;
        this.iron = iron;
    }

    public void changeResource(int gold, int wood, int iron){
        this.gold += gold;
        this.wood += wood;
        this.iron += iron;
    }

    public int[] getResource(){
        return new int[]{gold,wood,iron};
    }
}
