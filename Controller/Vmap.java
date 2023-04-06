package Controller;
import Model.Interface.Building;

import java.util.Arrays;

//a data structure for recording the village map using Integer array
public class Vmap {
    private char[][] map;

    Vmap(){
        this.map = new char[50][50];
        for(int i = 0;i<this.map.length;i++){
            Arrays.fill(this.map[i],' ');
        }
        this.map[0][0] = 'V';
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
    public boolean moveBuilding(Building building,int[] curPosition, int[] targetPosition){
        if(this.map[targetPosition[0]][targetPosition[1]] != ' '){
            System.err.println("Target position is not empty!");
            return false;
        }
        else{
            this.map[targetPosition[0]][targetPosition[1]] = building.getName().charAt(0);
            this.map[curPosition[0]][curPosition[1]] = ' ';
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

    public void printMap(){
        System.out.print(" ");
        for(int i = 0;i<this.map.length;i++){
            System.out.print(i+" ");
        }
        System.out.println();
        for(int i = 0;i<this.map.length;i++){
            System.out.print(i);
            for(int j = 0;j<this.map[0].length;j++){
                System.out.print(this.map[i][j]+" ");
            }
            System.out.println();
        }
    }
}
