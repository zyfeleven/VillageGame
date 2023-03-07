package Village;

import java.util.HashMap;

//calculate all kinds of scores here (attack, defence, develop)
//only develop now tho
public class ScoreCalculator {
    private final HashMap<String, Integer> dictionary = new HashMap<String, Integer>(){{
        put("VillageHall",100);
        put("ArcherTower",80);
        put("Cannons", 80);
        put("Farm", 30);
        put("GoldMine", 35);
        put("LumberHill", 35);
        put("IronMine", 35);
    }};
    public ScoreCalculator(){}
    public int calculateScore(String name, int level){
        int base = dictionary.get("name");
        return base*level;
    }
}
