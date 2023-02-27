package Building;

import Inhabitant.Inhabitant;

import java.util.ArrayList;
import java.util.HashSet;

public interface Defence extends Building{


    void addArmy(Inhabitant army);

    int getDmg();


}
