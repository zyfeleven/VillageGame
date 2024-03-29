/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server.Model.ChallengeDecision;

import java.util.ArrayList;
import java.util.List;
import Server.Model.ChallengeDecision.*;

/**
 *
 * @author robson
 */
public class ChallengeResult {
    Boolean challengeWon;
    List<ChallengeResource<Double,Double>> loot;

    public ChallengeResult( Boolean won, List<ChallengeResource<Double,Double>> loot ) {
        challengeWon = won;
        this.loot = loot;
    }
    
    public ChallengeResult( Boolean won ) {
        challengeWon = won;
        loot = new ArrayList<>();
    }
    
    public Boolean getChallengeWon() {
        return challengeWon;
    }
    
    public List<ChallengeResource<Double,Double>> getLoot() {
        return loot;
    }
    
    public void print() {
        System.out.println( "Result: " + challengeWon );
        for ( ChallengeResource e : loot ) {
            e.print();
        }
    }
}
