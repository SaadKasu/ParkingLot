package Repository;

import Models.Gate;
import Models.ParkingLot;

import java.util.HashMap;
import java.util.Optional;
import java.util.TreeMap;

public class ParkingLotRepository {
    private TreeMap<Long,ParkingLot> parkingLotHashMap = new TreeMap<>();
    public Optional<ParkingLot> getParkingLotForGate(Gate gate){
        for (ParkingLot parkingLot : parkingLotHashMap.values()){
            if (parkingLot.getEntryGate().equals(gate))
                return Optional.of(parkingLot);
        }
        return Optional.empty();
    }
}
