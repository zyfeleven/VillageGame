package Server.Model.Adapter;

import Server.Model.ChallengeDecision.ChallengeResource;
import Server.Model.Interface.Building;

public class ChallengeResourceConverter {
    public ChallengeResourceConverter(){}
    //convert a building to a ChallengeResource
    public ChallengeResource convert(Building building){
        double resource = building.getProduction()*100;
        double hp = building.getHp();
        ChallengeResource<Double,Double> ret = new ChallengeResource<>(resource,hp);
        return ret;
    }
}
