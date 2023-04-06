package Model.Adapter;

import ChallengeDecision.ChallengeAttack;
import Model.Interface.Inhabitant;

public class ChallengeAttackConverter {
    public ChallengeAttackConverter(){

    }
    //convert an inhabitant to a ChallengeAttack
    public ChallengeAttack convert(Inhabitant inhabitant){
        double dmg = inhabitant.getDmg();
        double hitpoint = inhabitant.getHp();
        ChallengeAttack<Double,Double> ret = new ChallengeAttack<>(dmg,hitpoint);
        return ret;
    }
}
