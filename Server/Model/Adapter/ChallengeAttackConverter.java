package Server.Model.Adapter;

import Server.Model.ChallengeDecision.ChallengeAttack;
import Server.Model.Interface.Inhabitant;

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
