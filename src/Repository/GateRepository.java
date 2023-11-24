package Repository;

import Models.Gate;

import java.util.HashMap;
import java.util.Optional;

public class GateRepository {
    private HashMap<Long, Gate> gateRepo = new HashMap<>();
    public Optional<Gate> findGateById(long id){

        return gateRepo.containsKey(id) ? Optional.ofNullable(gateRepo.get(id)) : Optional.empty();
    }
}
