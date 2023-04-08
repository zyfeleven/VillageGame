package Server.Model.Adapter;

import Server.Model.ChallengeDecision.ChallengeDefense;
import Server.Model.Interface.Building;
import Server.Model.Interface.Inhabitant;

public class ChallengeDefenseConverter {
    public ChallengeDefenseConverter(){};

    //convert a building to a ChallengeDefense
    public ChallengeDefense convert(Building building){
        double attack = building.getDmg();
        double hp = building.getHp();
        ChallengeDefense<Double,Double> ret = new ChallengeDefense<>(attack,hp);
        return ret;
    }
    //overload
    public ChallengeDefense convert(Inhabitant inhabitant){
        double attack = inhabitant.getDmg();
        double hp = inhabitant.getHp();
        ChallengeDefense<Double,Double> ret = new ChallengeDefense<>(attack,hp);
        return ret;
    }
}
