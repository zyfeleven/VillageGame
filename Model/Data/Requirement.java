package Model.Data;

import java.util.HashMap;

public class Requirement {
    //requirement for constructing a new building
    //for int[], it represents the number of i level buildings.
    //example: level2 Cannons needs level2 VillageHall and at least 3 level2 IronMines
    //then: in the Requirement of lv2 Cannons, VillageHall == 2, IronMine = [0,3,0,0,0].
    private int VillageHall;
    private HashMap<String, int[]> data;

    public Requirement(int VillageHall, int[] Farm, int[] GoldMine, int[] LumberHill, int[] IronMine, int[] Cannons, int[] ArcherTower){
        this.VillageHall = VillageHall;
        data = new HashMap<String, int[]>(){{
            put("Farm",Farm);
            put("ArcherTower", ArcherTower);
            put("Cannons", Cannons);
            put("IronMine", IronMine);
            put("GoldMine", GoldMine);
            put("LumberHill", LumberHill);
        }};
    }

    public int getVillageHall(){
        return this.VillageHall;
    }

    public int[] getRecord(String name){
        return this.data.get(name);
    }
}
