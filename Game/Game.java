package Game;

import Exception.*;
import Data.Data;
import Inhabitant.*;
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
                System.out.println("Invalid option!");
                continue;
            }
            else{
                int temp = 0;
                try{
                    temp = Integer.parseInt(index);
                } catch (NumberFormatException e){
                    System.out.println("Invalid option!");
                }
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
                    this.printBuildings();
                }
                else if(temp == 5){

                }
                else if(temp == 6){

                }
                else if(temp == 7){

                }
                else if(temp == 8){

                }
                else System.out.println("invalid option!");
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
        ArrayList<?> armies = this.user.getInhabitants("Armies");
        HashMap<int[], Building> buildings = this.user.getBuildings();
        int option = -1;
        while(option!=0){
            System.out.println("Please select a inhabitant type: ");
            System.out.println("1.Worker"+" current have "+workers.size());
            System.out.println("2.Miner"+" current have "+miners.size());
            System.out.println("3.Archer"+" current have "+archers.size());
            System.out.println("4.Soldier"+" current have "+soldiers.size());
            System.out.println("5.Knight"+" current have "+knights.size());
            System.out.println("6.Catapult"+" current have "+catapults.size());
            System.out.println("7. Armies");
            System.out.println("0. Back to main menu");
            String index = this.scanner.nextLine();
            if(index.length()!=1){
                System.out.println("Invalid input!");
            }
            else{
                if(index.charAt(0)<'0'||index.charAt(0)>'9'){
                    System.out.println("Invalid input!");
                    continue;
                }
                int temp = Integer.parseInt(index);
                if(temp == 0){
                    return;
                }
                //Worker
                else if(temp == 1){
                    for(int i = 0;i<workers.size();i++){
                        Worker worker = (Worker) workers.get(i);
                        int[] workPosition = worker.workPosition();
                        System.out.print("Worker"+i+"  production: "+worker.getProduction()+"  attack: "+worker.getDmg());
                        if(worker.isArmy()){
                            System.out.println(" in the army now");
                        }
                        else if(workPosition[0] == -1&&workPosition[1] == -1){
                            System.out.println();
                        }
                        else{
                            Building b = this.user.getBuilding(workPosition);
                            System.out.print(" working at "+b.getName()+" ["+workPosition[0]+","+workPosition[1]+"] now");
                            System.out.println();
                        }
                    }
                    System.out.println("Select an inhabitant to continue (select an index)");
                    String s = this.scanner.nextLine();
                    int i = -1;
                    try{
                        i = Integer.parseInt(s);
                    } catch(NumberFormatException e){
                        System.out.println("Invalid input!");
                        continue;
                    }
                    if(i<0 || i>workers.size()-1){
                        System.out.println("Invalid index");
                        continue;
                    }
                    this.InhabitantOperations("Worker",i,buildings);
                }
                //Miner
                else if(temp == 2){
                    for(int i = 0;i<miners.size();i++){
                        Miner miner = (Miner) miners.get(i);
                        int[] workPosition = miner.workPosition();
                        System.out.print("Miner"+i+"  production: "+miner.getProduction()+"  attack: "+miner.getDmg());
                        if(miner.isArmy()){
                            System.out.println(" in the army now");
                        }
                        else if(workPosition[0] == -1&&workPosition[1] == -1){
                            System.out.println();
                        }
                        else{
                            Building b = this.user.getBuilding(workPosition);
                            System.out.print(" working at "+b.getName()+" ["+workPosition[0]+","+workPosition[1]+"] now");
                            System.out.println();
                        }
                    }
                    System.out.println("Select an inhabitant to continue (select an index)");
                    String s = this.scanner.nextLine();
                    int i = -1;
                    try{
                        i = Integer.parseInt(s);
                    } catch(NumberFormatException e){
                        System.out.println("Invalid input!");
                        continue;
                    }
                    if(i<0 || i>miners.size()-1){
                        System.out.println("Invalid index");
                        continue;
                    }
                    this.InhabitantOperations("Miner",i,buildings);
                }
                //Archer
                else if(temp == 3){
                    for(int i = 0;i<archers.size();i++){
                        Archer archer = (Archer) archers.get(i);
                        int[] workPosition = archer.workPosition();
                        System.out.print("Archer"+i+"  production: "+archer.getProduction()+"  attack: "+archer.getDmg());
                        if(archer.isArmy()){
                            System.out.println(" in the army now");
                        }
                        else if(workPosition[0] == -1&&workPosition[1] == -1){
                            System.out.println();
                        }
                        else{
                            Building b = this.user.getBuilding(workPosition);
                            System.out.print(" working at "+b.getName()+" ["+workPosition[0]+","+workPosition[1]+"] now");
                            System.out.println();
                        }
                    }
                    System.out.println("Select an inhabitant to continue (select an index)");
                    String s = this.scanner.nextLine();
                    int i = -1;
                    try{
                        i = Integer.parseInt(s);
                    } catch(NumberFormatException e){
                        System.out.println("Invalid input!");
                        continue;
                    }
                    if(i<0 || i>archers.size()-1){
                        System.out.println("Invalid index");
                        continue;
                    }
                    this.InhabitantOperations("Archer",i,buildings);
                }
                //Soldier
                else if(temp == 4){
                    for(int i = 0;i<soldiers.size();i++){
                        Soldier soldier = (Soldier) soldiers.get(i);
                        int[] workPosition = soldier.workPosition();
                        System.out.print("Archer"+i+"  production: "+soldier.getProduction()+"  attack: "+soldier.getDmg());
                        if(soldier.isArmy()){
                            System.out.println(" in the army now");
                        }
                        else if(workPosition[0] == -1&&workPosition[1] == -1){
                            System.out.println();
                        }
                        else{
                            Building b = this.user.getBuilding(workPosition);
                            System.out.print(" working at "+b.getName()+" ["+workPosition[0]+","+workPosition[1]+"] now");
                            System.out.println();
                        }
                    }
                    System.out.println("Select an inhabitant to continue (select an index)");
                    String s = this.scanner.nextLine();
                    int i = -1;
                    try{
                        i = Integer.parseInt(s);
                    } catch(NumberFormatException e){
                        System.out.println("Invalid input!");
                        continue;
                    }
                    if(i<0 || i>soldiers.size()-1){
                        System.out.println("Invalid index");
                        continue;
                    }
                    this.InhabitantOperations("Soldier",i,buildings);
                }
                //Knight
                else if(temp == 5){
                    for(int i = 0;i<knights.size();i++){
                        Knight knight = (Knight) knights.get(i);
                        int[] workPosition = knight.workPosition();
                        System.out.print("Archer"+i+"  production: "+knight.getProduction()+"  attack: "+knight.getDmg());
                        if(knight.isArmy()){
                            System.out.println(" in the army now");
                        }
                        else if(workPosition[0] == -1&&workPosition[1] == -1){
                            System.out.println();
                        }
                        else{
                            Building b = this.user.getBuilding(workPosition);
                            System.out.print(" working at "+b.getName()+" ["+workPosition[0]+","+workPosition[1]+"] now");
                            System.out.println();
                        }
                    }
                    System.out.println("Select an inhabitant to continue (select an index)");
                    String s = this.scanner.nextLine();
                    int i = -1;
                    try{
                        i = Integer.parseInt(s);
                    } catch(NumberFormatException e){
                        System.out.println("Invalid input!");
                        continue;
                    }
                    if(i<0 || i>knights.size()-1){
                        System.out.println("Invalid index");
                        continue;
                    }
                    this.InhabitantOperations("Knight",i,buildings);
                }
                //Catapult
                else if(temp == 6){
                    for(int i = 0;i<catapults.size();i++){
                        Catapult catapult = (Catapult) catapults.get(i);
                        int[] workPosition = catapult.workPosition();
                        System.out.print("Archer"+i+"  production: "+catapult.getProduction()+"  attack: "+catapult.getDmg());
                        if(catapult.isArmy()){
                            System.out.println(" in the army now");
                        }
                        else if(workPosition[0] == -1&&workPosition[1] == -1){
                            System.out.println();
                        }
                        else{
                            Building b = this.user.getBuilding(workPosition);
                            System.out.print(" working at "+b.getName()+" ["+workPosition[0]+","+workPosition[1]+"] now");
                            System.out.println();
                        }
                    }
                    System.out.println("Select an inhabitant to continue (select an index)");
                    String s = this.scanner.nextLine();
                    int i = -1;
                    try{
                        i = Integer.parseInt(s);
                    } catch(NumberFormatException e){
                        System.out.println("Invalid input!");
                        continue;
                    }
                    if(i<0 || i>catapults.size()-1){
                        System.out.println("Invalid index");
                        continue;
                    }
                    this.InhabitantOperations("Catapult",i,buildings);
                }
                else System.out.println("Invalid option!");
            }
        }
    }

    public void InhabitantOperations(String name, int i, HashMap<int[],Building> buildings){

        System.out.println("Options: ");
        System.out.println("1. Set work building for this inhabitant.");
        System.out.println("2. Add this inhabitant to the army");
        System.out.println("3. Call back this inhabitant from the building");
        System.out.println("4. Call back this inhabitant from the army");
        System.out.println("5. Remove this inhabitant");
        System.out.println("0. Back");
        String index1 = this.scanner.nextLine();
        if(index1.length()!=1){
            System.out.println("Invalid option!");
            return;
        }
        else{
            int temp1 = Integer.parseInt(index1);
            if(temp1 == 1){
                System.out.println("Please enter the position of the target building:");
                for(Map.Entry<int[], Building> entry: buildings.entrySet()){
                    Building building = entry.getValue();
                    System.out.println(building.getName()+" position: ["+entry.getKey()[0]+","+entry.getKey()[1]+"]");
                }
                System.out.println("Example: 0,0 (no spacing)");
                String position = this.scanner.nextLine();
                int pos1 = 50;
                int pos2 = 50;
                try{
                    String[] strings = position.split(",");
                    pos1 = Integer.parseInt(strings[0]);
                    pos2 = Integer.parseInt(strings[1]);
                } catch (NumberFormatException e){
                    System.out.println("Invalid position!");
                    return;
                }
                if(pos1<0||pos1>49||pos2<0||pos2>49||!buildings.containsKey(new int[]{pos1,pos2})){
                    System.out.println("Invalid position!");
                    return;
                }
                this.user.addWorkersToBuilding(i,name,new int[]{pos1,pos2});
            }
            else if(temp1 == 2){
                this.user.addArmies(i,name);
            }
            else if(temp1 == 3){
                this.user.removeWorkerFromBuilding(name, i);
            }
            else if(temp1 == 4){
                this.user.removeArmy(name,i);
            }
            else if(temp1 == 5){
                this.user.removeWorker(name,i);
            }
            else if(temp1 == 0){
                return;
            }
        }
    }

    public void printBuildings(){

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
