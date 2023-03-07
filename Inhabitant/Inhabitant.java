package Inhabitant;

public interface Inhabitant {
    //return the name of inhabitant
    String getName();
    //return the production speed of this inhabitant
    double getProduction();
    //return the dmg of this inhabitant
    double getDmg();
    //return current work position of this inhabitant(if not working then return [-1,-1])
    int[] workPosition();
    //set up a position for this inhabitant to work
    void work(int[] position);
    //return true if this inhabitant is in army
    boolean isArmy();
    //overload, set a boolean for this inhabitant to determine whether it's in army
    void isArmy(boolean b);
}
