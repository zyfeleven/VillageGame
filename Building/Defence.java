package Building;

import Inhabitant.Inhabitant;

import java.util.ArrayList;
import java.util.HashSet;

public interface Defence extends Building{


    void addWorker(Inhabitant army);

    double getDmg();

    HashSet<?> getWorkers();
}
