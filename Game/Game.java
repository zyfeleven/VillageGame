package Game;

import Data.Data;
import Village.Village;
import Village.Resource;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Game {
    //current user
    private Village user;
    private Timer timer;
    private TimerTask counter;
    private int time;
    private double[] production;
    private Scanner scanner;


    private final Data data = new Data();

    //constructor
    Game(){
        user = new Village();
        timer = new Timer();
        time = 0;
        this.production = user.getProduction();
        this.scanner = new Scanner(System.in);
        this.counter = new TimerTask() {
            @Override
            public void run() {
                time++;
                user.addResource(production[0],production[1],production[2]);
            }
        };
        timer.scheduleAtFixedRate(this.counter,0,1000);
        this.main(this.scanner);
    }

    public void main(Scanner scanner){
        int option = -1;
        while(option != 0){
            System.out.println("Hi player! Please select an option: ");
            System.out.println("1. View of my village");
            System.out.println("2. Details of my village");
            System.out.println("3. Details of my inhabitants");
            System.out.println("4. Details of my buildings");
            System.out.println("5. Train new inhabitant");
            System.out.println("6. Add new building");
            System.out.println("7. New to the game? Help info");
            System.out.println("0. Exit");
            String index = scanner.nextLine();
        }

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
    public void updateResource(){}


    //calculate current user's score
    public int retScore(){
        return 0;
    }

}
