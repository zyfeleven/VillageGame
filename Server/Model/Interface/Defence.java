package Server.Model.Interface;

import java.util.HashSet;

public interface Defence extends Building{


    void addWorker(Inhabitant army);

    double getDmg();

    HashSet<Inhabitant> getWorkers();
}
