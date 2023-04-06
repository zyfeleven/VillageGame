package Model;

import java.util.HashMap;
import java.util.Map;

public class VillageRecord {
    private int VillageHall;
    private HashMap<String, int[]> data;

    //record the numbers of buildings and their level
    public VillageRecord(){
        this.VillageHall = 1;
        data = new HashMap<String, int[]>(){{
            put("Farm",new int[]{0,0,0});
            put("ArcherTower", new int[]{0,0,0});
            put("Cannons", new int[]{0,0,0});
            put("IronMine", new int[]{0,0,0});
            put("GoldMine", new int[]{0,0,0});
            put("LumberHill", new int[]{0,0,0});
        }};
    }

    public void add(String name){
        data.get(name)[0]++;
    }

    public void upgrade(String name, int level){
        if(name.equals("VillageHall")){
            this.VillageHall++;
        }
        else{
            data.get(name)[level]--;
            data.get(name)[level+1]++;
        }
    }

    public void remove(String name, int level){
        data.get(name)[level]--;
    }

    public int getScore(){
        int sum = 0;
        int[] temp;
        sum += 100*this.VillageHall;
        temp = this.data.get("Farm");
        sum = sum + temp[0]*30 + temp[1]*60 + temp[2]*90;
        temp = this.data.get("GoldMine");
        sum = sum + temp[0]*30 + temp[1]*60 + temp[2]*90;
        temp = this.data.get("IronMine");
        sum = sum + temp[0]*30 + temp[1]*60 + temp[2]*90;
        temp = this.data.get("LumberHill");
        sum = sum + temp[0]*30 + temp[1]*60 + temp[2]*90;
        temp = this.data.get("Cannons");
        sum = sum + temp[0]*80 + temp[1]*160 + temp[2]*240;
        temp = this.data.get("ArcherTower");
        sum = sum + temp[0]*80 + temp[1]*160 + temp[2]*240;
        return sum;
    }

    public int getVillageHall(){
        return this.VillageHall;
    }

    public int[] getRecord(String name){
        return this.data.get(name);
    }
}
