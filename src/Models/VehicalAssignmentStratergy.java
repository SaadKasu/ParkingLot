package Models;

import java.util.List;

public interface VehicalAssignmentStratergy {
    public VehicalSlot assignSlot(List<Floor> listOfFloors, VehicalType typeOfVehical);
}
