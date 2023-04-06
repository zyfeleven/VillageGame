package View;

import Exception.*;
import Model.Data.Data;
import Model.Adapter.ChallengeAdapter;
import Model.Factory.BuildingFactory;
import Model.Inhabitant.*;
import Model.Interface.Building;
import Model.Interface.Inhabitant;
import Controller.Village;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class Game {
    //current user
    private Village user;
    //timer
    private Timer timer;
    //a task that will increase gameTime by 1 per second and add resource
    private TimerTask counter;
    //game time
    private int time;
    //current production order by gold, wood, iron
    private double[] production;
    //scanner for user input
    private Scanner scanner;

    //all constants here
    private final Data data = new Data();

    //constructor
    public Game() throws InvalidOptionException {
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
        //do it every second
        timer.scheduleAtFixedRate(this.counter,0,1000);
    }

    //main menu
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
                    this.exitGame();
                    return;
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
                    this.production = this.user.getProduction();
                }
                else if(temp == 4){
                    this.printBuildings();
                    this.production = this.user.getProduction();
                }
                else if(temp == 5){
                    this.addInhabitant();
                }
                else if(temp == 6){
                    this.addBuilding();
                    this.production = this.user.getProduction();
                }
                else if(temp == 7){
                    ChallengeAdapter adapter = new ChallengeAdapter(this.user,new Village());
                    adapter.getResult().print();
                }
                else if(temp == 8){
                    this.printHints();
                }
                else System.out.println("invalid option!");
            }
        }
    }

    //randomly generate a village to attack (update in the future)
    public Village generateVillage(){
        return null;
    }

    //print the map of user's village
    public void viewOfVillage(){
        this.user.printMap();
    }

    //print all inhabitant information for user
    public void printInhabitants() throws InvalidOptionException {
        //all arraylists of inhabitants
        ArrayList<? extends Inhabitant> workers = this.user.getInhabitants("Worker");
        ArrayList<? extends Inhabitant> miners = this.user.getInhabitants("Miner");
        ArrayList<? extends Inhabitant> catapults = this.user.getInhabitants("Catapult");
        ArrayList<? extends Inhabitant> soldiers = this.user.getInhabitants("Soldier");
        ArrayList<? extends Inhabitant> archers = this.user.getInhabitants("Archer");
        ArrayList<? extends Inhabitant> knights = this.user.getInhabitants("Knight");
        //armies will be used in the future when involving attacking and defencing
        ArrayList<? extends Inhabitant> armies = this.user.getInhabitants("Armies");
        //all buildings of the village, used here to show which building and position the inhabitant is working in
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

    //operations of an inhabitant
    public void InhabitantOperations(String name, int i, HashMap<int[],Building> buildings){
        //all operations
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
            }
        }
    }

    //print all information of buildings in the village
    public void printBuildings(){
        HashMap<int[], Building> buildings = this.user.getBuildings();
        for(Map.Entry<int[],Building> entry:buildings.entrySet()){
            Building b = entry.getValue();
            int[] position = entry.getKey();
            System.out.print(b.getName()+"  position:["+position[0]+","+position[1]+"] ");
            System.out.print("production: "+b.getProduction()+" dmg: "+b.getDmg()+" workers: "+b.getCurWorker()[0]+"/"+b.getCurWorker()[1]);
            System.out.println();
        }
        System.out.println("Select an option: ");
        System.out.println("1. Select a building");
        System.out.println("Press any other number to back to main menu");
        String option = this.scanner.nextLine();
        int temp = -1;
        try{
            temp = Integer.parseInt(option);
        }catch (NumberFormatException e){
            System.out.println("Invalid option!");
        }
        if(temp == 1){
            while(true){
                System.out.println("Please input target building's position (format: 0,0)");
                String position = this.scanner.nextLine();
                String[] s = position.split(",");
                int pos1 = -1;
                int pos2 = -1;
                try{
                    pos1 = Integer.parseInt(s[0]);
                    pos2 = Integer.parseInt(s[1]);
                } catch (NumberFormatException e){
                    System.out.println("Invalid position");
                }
                if(!buildings.containsKey(new int[]{pos1,pos2})){
                    System.out.println("There is no building at this position");
                    continue;
                }
                else{
                    this.buildingOperation(new int[]{pos1,pos2});
                    break;
                }
            }

        }
        else{
            return;
        }
    }

    //all operations for buildings
    public void buildingOperation(int[] position){
        Building building = this.user.getBuilding(position);
        HashSet<Inhabitant> set = building.getWorkers();
        ArrayList<Inhabitant> workers = new ArrayList(set);
        System.out.println("Options: ");
        System.out.println("1. Upgrade");
        System.out.println("2. Move");
        System.out.println("3. Remove");
        System.out.println("4. Workers detail");
        String option = this.scanner.nextLine();
        int index = -1;
        try{
            index = Integer.parseInt(option);
        }catch (NumberFormatException e){
            System.out.println("Invalid option!");
        }
        if(index == 1){
            //for upgrading the user must select a worker to do the job
            System.out.println("Please select a worker");
            ArrayList<? extends Inhabitant> Workers = this.user.getInhabitants("Worker");
            for(int i = 0;i<Workers.size();i++){
                Inhabitant worker = Workers.get(i);
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
            int choice = -1;
            String s = this.scanner.nextLine();
            try{
                choice = Integer.parseInt(s);
            } catch (NumberFormatException e){
                System.out.println("Invalid option!");
            }
            if(Workers.get(choice).isArmy()||Workers.get(choice).workPosition()[0]!=-1||Workers.get(choice).workPosition()[1]!=-1){
                System.out.println("This worker is not available!");
                return;
            }
            if(!this.user.upgradeBuilding(position,this.timer,(Worker) Workers.get(choice))){
                System.out.println("Upgrade failed");
            }
        }
        else if(index == 2){
            this.viewOfVillage();
            System.out.println("The building you selected is ["+position[0]+","+position[1]+"]");
            System.out.println("Please choose a position to move: (format:0,0)");
            String s = this.scanner.nextLine();
            int[] targetPos = new int[2];
            try {
                String[] str = s.split(",");
                targetPos[0] = Integer.parseInt(str[0]);
                targetPos[1] = Integer.parseInt(str[1]);
            } catch (NumberFormatException e){
                System.out.println("Invalid position");
                return;
            }
            this.user.moveBuilding(position,targetPos);
        }
        else if(index == 3){
            this.user.removeBuilding(position);
        }
        else if(index == 4){
            System.out.println("Current workers in this building: ");
            for(int i = 0;i<workers.size();i++){
                Inhabitant temp = workers.get(i);
                System.out.println(i+"."+temp.getName()+" production: "+temp.getProduction()+" dmg"+ temp.getDmg());
            }
            System.out.println("1.I just want to have a look and then back");
            System.out.println("2.I want to remove one worker from this building");
            String choice = this.scanner.nextLine();
            int i = -1;
            try {
                i = Integer.parseInt(choice);
            } catch (NumberFormatException e){
                System.out.println("Invalid option!");
                return;
            }
            if(i == 1){
                return;
            }
            else if(i == 2){
                System.out.println("Please select the index of worker");
                String w = this.scanner.nextLine();
                int worker = -1;
                try {
                    worker = Integer.parseInt(w);
                } catch (NumberFormatException e){
                    System.out.println("Invalid Number!");
                    return;
                }
                building.removeWorker(workers.get(worker));
            }
        }

    }

    //add a new inhabitant
    public void addInhabitant(){
        System.out.println("Choose a inhabitant type: ");
        System.out.println("1. Worker");
        System.out.println("2. Miner");
        System.out.println("3. Knight");
        System.out.println("4. Archer");
        System.out.println("5. Catapult");
        System.out.println("6. Soldier");
        String s = this.scanner.nextLine();
        String name = "";
        int i = -1;
        try{
            i = Integer.parseInt(s);
        } catch (NumberFormatException e){
            System.out.println("Invalid option!");
        }
        if(i == 1){
            name = "Worker";
        }
        else if(i == 2){
            name = "Miner";
        }
        else if(i == 3){
            name = "Knight";
        }
        else if(i == 4){
            name = "Archer";
        }
        else if(i == 5){
            name = "Catapult";
        }
        else if(i == 6){
            name = "Soldier";
        }
        else{
            System.out.println("Invalid option!");
            return;
        }
        if(this.user.addInhabitant(name, this.timer)){
            System.out.println("The inhabitant is training now");
        }
        else{
            System.out.println("There is no enough resource to train new inhabitant");
        }
    }
    //attack a specific village, if the attack is successful then count the loot
    public void attackVillage(Village village){
        System.out.println("Will be supported in the future...");
    }

    //add a new building
    public void addBuilding(){
        System.out.println("Choose a building type: ");
        System.out.println("1. Farm");
        System.out.println("2. GoldMine");
        System.out.println("3. IronMine");
        System.out.println("4. LumberHill");
        System.out.println("5. ArcherTower");
        System.out.println("6. Cannons");
        String s = this.scanner.nextLine();
        Building building;
        int index = -1;
        try{
            index = Integer.parseInt(s);
        } catch (NumberFormatException e){
            System.out.println("Invalid option!");
        }
        building = new BuildingFactory(){}.retBuilding(index);
        if(index<1||index>6){
            System.out.println("Invalid option!");
            return;
        }
        System.out.println("Please select a worker");
        ArrayList<? extends Inhabitant> Workers = this.user.getInhabitants("Worker");
        for(int i = 0;i<Workers.size();i++){
            Inhabitant worker = Workers.get(i);
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
        int choice = -1;
        String str = this.scanner.nextLine();
        try{
            choice = Integer.parseInt(str);
        } catch (NumberFormatException e){
            System.out.println("Invalid option!");
        }
        if(Workers.get(choice).isArmy()||Workers.get(choice).workPosition()[0]!=-1||Workers.get(choice).workPosition()[1]!=-1){
            System.out.println("This worker is not available!");
            return;
        }
        System.out.println("Please choose a position: (format 0,0)");
        int[] position = new int[2];
        String s1 = this.scanner.nextLine();
        try {
            String[] strings = s1.split(",");
            position[0] = Integer.parseInt(strings[0]);
            position[1] = Integer.parseInt(strings[1]);
        } catch (NumberFormatException e){
            System.out.println("Invalid position");
        }
        if(this.user.addBuilding(building,position,this.timer,(Worker)Workers.get(choice))){
            System.out.println("The building is under construction now");
        }
        else{
            System.out.println("There is no enough resource to add new building or the requirement is not met");
        }
    }

    //read hints from file and print
    public void printHints(){
        try {
            System.out.println("----------");
            BufferedReader br = new BufferedReader(new FileReader(new File("readMe.txt")));
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            System.out.println("----------");
            br.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


    //calculate current user's score (update in the future)
    public int retScore(){
        return 0;
    }

    //exit the game, cancel the timer task
    public void exitGame(){
        this.timer.cancel();
    }

}
