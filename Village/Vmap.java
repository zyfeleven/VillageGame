package Village;
import Building.*;
import Data.Data;
import Data.Requirement;

//a data structure for recording the village map using Integer array
public class Vmap {
    private char[][] map;

    Vmap(){
        this.map = new char[999][999];
    }

    //add a building in the map, if there is already one building in the area then return false, else build the building and return true
    public boolean addBuilding(Building building, int[] position){
        if(this.map[position[0]][position[1]] != ' '){
            System.err.println("Target position is not empty!");
            return false;
        }
        else{
            this.map[position[0]][position[1]] = building.getName().charAt(0);
            return true;
        }
    }

    //move one building from a place to another place, return false if the operation is invalid
    public boolean moveBuilding(Building building, int[] position){
        if(this.map[position[0]][position[1]] != ' '){
            System.err.println("Target position is not empty!");
            return false;
        }
        else{
            this.map[position[0]][position[1]] = building.getName().charAt(0);
            return true;
        }
    }

    //remove one building from map
    public boolean removeBuilding(int[] position){
        if(this.map[position[0]][position[1]]=='V'){
            System.err.println("You can't remove village hall!");
            return false;
        }
        this.map[position[0]][position[1]] = ' ';
        return true;
    }
}
