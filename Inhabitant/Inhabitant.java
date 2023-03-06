package Inhabitant;

public interface Inhabitant {

    String getName();

    double getProduction();

    double getDmg();

    int[] workPosition();

    void work(int[] position);

    boolean isArmy();

    void isArmy(boolean b);
}
