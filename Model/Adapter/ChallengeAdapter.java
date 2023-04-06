package Model.Adapter;

import ChallengeDecision.*;
import Model.Interface.Building;
import Model.Interface.Inhabitant;
import Controller.Village;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChallengeAdapter {
    private Village attacker;
    private Village defender;

    public ChallengeAdapter(Village attacker, Village defender){
        this.attacker = attacker;
        this.defender = defender;
    }

    public ChallengeResult getResult(){
        ArrayList<? extends Inhabitant> attackerArmy = attacker.getArmy();
        ArrayList<? extends Inhabitant> defenderArmy = defender.getArmy();
        ChallengeDefenseConverter defenseConverter = new ChallengeDefenseConverter();
        ChallengeAttackConverter attackConverter = new ChallengeAttackConverter();
        ChallengeResourceConverter resourceConverter = new ChallengeResourceConverter();
        List<ChallengeAttack<Double,Double>> attackEntities = new ArrayList<>();
        List<ChallengeDefense<Double,Double>> defenseEntities = new ArrayList<>();
        List<ChallengeResource<Double,Double>> resourceList = new ArrayList<>();
        for(Inhabitant i:attackerArmy){
            attackEntities.add(attackConverter.convert(i));
        }
        for(Inhabitant i:defenderArmy){
            defenseEntities.add(defenseConverter.convert(i));
        }
        HashMap<int[], Building> defenseBuildings = defender.getBuildings();
        for(Map.Entry<int[],Building> entry: defenseBuildings.entrySet()){
            if(entry.getValue().getName().equals("Cannons")||entry.getValue().getName().equals("ArcherTower")){
                defenseEntities.add(defenseConverter.convert(entry.getValue()));
            }
            else{
                resourceList.add(resourceConverter.convert(entry.getValue()));
            }
        }
        ChallengeEntitySet<Double,Double> challenger = new ChallengeEntitySet<>(attackEntities,null,null);
        ChallengeEntitySet<Double,Double> challengee = new ChallengeEntitySet<>(null,defenseEntities,resourceList);
        return Arbitrer.challengeDecide(challenger,challengee);
    }




}
