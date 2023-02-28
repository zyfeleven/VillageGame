package Game;

import Data.Data;
import Village.Village;
import Village.Resource;

import java.util.Timer;

public class Game {
    //current user
    private Village user;
    //timer
    Timer timer;

    private final Data data = new Data();

    //constructor
    Game(){
        user = new Village();
    }

    //randomly generate a village to attack
    public Village generateVillage(){
        return null;
    }

    //attack a specific village, if the attack is successful then count the loot
    public void attackVillage(Village village){}

    //add user's resource with time going on
    public void addResource(Resource resource){}

    //reduce user's resource after operation
    public void reduceResource(Resource resource){}

    //initialize the game(new game)
    public void initialize(){}

    //load user data from file
    public void loadUser(){}

    //start the game
    public void startGame(){}

    //exit the game and store user data in file
    public void exitGame(){}

    //check whether the building at target position could be upgraded
    public boolean canUpgrade(int[] position){return true;}

    //upgrade the building
    public void upgradeBuilding(int[] position){}

    //add new building
    public void addBuilding(String buildingName){}

    //update user's resource(gold/wood/iron) after construct new buildings/gain loot/natural production
    public void updateResource(){};

    //update user's production speed after related construction completed
    public void updateProductionSpeed(){};

    //calculate current user's score
    public int retScore(){
        return 0;
    }

}
