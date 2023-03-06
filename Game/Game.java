package Game;

import Exception.*;
import Data.Data;
import Inhabitant.Worker;
import Village.Village;
import Village.Resource;
import Building.*;
import java.util.*;


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
    Game() throws InvalidOptionException {
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
        this.main();
    }

    public void main() throws InvalidOptionException {
        int option = -1;
        while(option != 0){
            System.out.println("Hi player! Please select an option: ");
            System.out.println("1. View of my village");
            System.out.println("2. Details of my village");
            System.out.println("3. Details of my inhabitants");
            System.out.println("4. Details of my buildings");
            System.out.println("5. Train new inhabitant");
            System.out.println("6. Add new building");
            System.out.println("7. Attacking");
            System.out.println("8. New to the game? Help info");
            System.out.println("0. Exit");
            String index = scanner.nextLine();
            if(index.length()!=1){
                throw new InvalidOptionException("Invalid option!");
            }
            else{
                int temp = Integer.valueOf(index);
                if(temp == 0){
                    break;
                }
                else if(temp == 1){
                    this.viewOfVillage();
                }
                else if(temp == 2){
                    System.out.println("Game time: "+this.time);
                    this.user.printDetails();
                }
                else if(temp == 3){
                    this.printInhabitants();
                }
                else if(temp == 4){

                }
                else if(temp == 5){

                }
                else if(temp == 6){

                }
                else if(temp == 7){

                }
                else if(temp == 8){

                }
            }
        }

    }

    //randomly generate a village to attack
    public Village generateVillage(){
        return null;
    }

    public void viewOfVillage(){
        this.user.printMap();
    }

    public void printInhabitants() throws InvalidOptionException {
        ArrayList<?> workers = this.user.getInhabitants("Worker");
        ArrayList<?> miners = this.user.getInhabitants("Miner");
        ArrayList<?> catapults = this.user.getInhabitants("Catapult");
        ArrayList<?> soldiers = this.user.getInhabitants("Soldier");
        ArrayList<?> archers = this.user.getInhabitants("Archer");
        ArrayList<?> knights = this.user.getInhabitants("Knight");
        int option = -1;
        while(option!=0){
            System.out.println("Please select a inhabitant type: ");
            System.out.println("1.Worker"+" current have "+workers.size());
            System.out.println("2.Miner"+" current have "+miners.size());
            System.out.println("3.Archer"+" current have "+archers.size());
            System.out.println("4.Soldier"+" current have "+soldiers.size());
            System.out.println("5.Knight"+" current have "+knights.size());
            System.out.println("6.Catapult"+" current have "+catapults.size());
            System.out.println("0. Back to main menu");
            String index = this.scanner.nextLine();
            if(index.length()!=1){
                throw new InvalidOptionException("Invalid option!");
            }
            else{
                int temp = Integer.valueOf(index);
                if(temp == 0){
                    return;
                }
                else if(temp == 1){
                    for(int i = 0;i<workers.size();i++){
                        Worker worker = (Worker) workers.get(i);
                        int[] workPosition = worker.workPosition();
                        System.out.print("Worker"+i+"  production: "+worker.getProduction()+"  attack: "+worker.getDmg());
                        if(workPosition[0] == 0&&workPosition[1] == 0){
                            System.out.println();
                            continue;
                        }
                        else{
                            Building b = this.user.getBuilding(workPosition);
                            System.out.print("working at "+b.getName()+" ["+workPosition[0]+","+workPosition[1]+"]");
                            System.out.println();
                        }
                    }
                    System.out.println("Options: ");
                    System.out.println("1. Set work building for this inhabitant.");
                    System.out.println("2. Add this inhabitant to the army");
                    System.out.println("3. Call back this inhabitant from the building");
                    System.out.println("4. Call back this inhabitant from the army");
                    System.out.println("5. Remove this inhabitant");
                    System.out.println("0. Back");
                    String index1 = this.scanner.nextLine();

                }
                else if(temp == 2){

                }
                else if(temp == 3){

                }
                else if(temp == 4){

                }
                else if(temp == 5){

                }
                else if(temp == 6){

                }
                else if(temp == 7){

                }
                else if(temp == 8){

                }
            }
        }
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
