package Data;

public class Requirement {
    //requirement for constructing a new building
    //for int[], it represents the number of i level buildings.
    //example: level2 Cannons needs level2 VillageHall and at least 3 level2 IronMines
    //then: in the Requirement of lv2 Cannons, VillageHall == 2, IronMine = [0,3,0,0,0].
    private int VillageHall;
    private int[] Farm;
    private int[] GoldMine;
    private int[] LumberHill;
    private int[] IronMine;
    private int[] Cannons;
    private int[] ArcherTower;

    public Requirement(int VillageHall, int[] Farm, int[] GoldMine, int[] LumberHill, int[] IronMine, int[] Cannons, int[] ArcherTower){
        this.VillageHall = VillageHall;
        this.Farm = Farm;
        this.GoldMine = GoldMine;
        this.LumberHill = LumberHill;
        this.IronMine = IronMine;
        this.Cannons = Cannons;
        this.ArcherTower = ArcherTower;
    }

    //get methods

    public int getVillageHall(){
        return this.VillageHall;
    }

    public int[] getGoldMine(){
        return this.GoldMine;
    }

    public int[] Cannons(){
        return this.Cannons;
    }

    public int[] getLumberHill(){
        return this.LumberHill;
    }

    public int[] getIronMine(){
        return this.IronMine;
    }

    public int[] getFarm(){
        return this.Farm;
    }

    public int[] getArcherTower(){
        return this.ArcherTower;
    }
}
