package Building;

import Inhabitant.Inhabitant;
import Inhabitant.Miner;

import java.util.HashSet;

public interface Mine extends Building{

    void addWorker(Inhabitant miner);

    HashSet<Inhabitant> getWorkers();
}
