package Village;

//a data structure for recording the village map using Integer array
public class Vmap {
    private int[][] map;

    Vmap(){
        this.map = new int[Integer.MIN_VALUE][Integer.MAX_VALUE];
    }

    //add a building in the map, if there is already one building in the area then return false, else build the building and return true
    public boolean addBuilding(int[] position){
        return true;
    }

    //move one building from a place to another place, return false if the operation is invalid
    public boolean moveBuilding(int[] curPosition, int[] targetPosition){
        return true;
    }

    //remove one building from map
    public boolean removeBuilding(int[] position){
        return true;
    }
}
