package Models;

import java.util.List;

public class FirstAvailableSlot extends BaseModel implements VehicalAssignmentStratergy{
    public VehicalSlot assignSlot(List<Floor> listOfFloors, VehicalType typeOfVehical){
        for(Floor currentFloor : listOfFloors){
            if (currentFloor.getFloorStatus() == StateOfFloor.OUT_OF_ORDER)
                continue;
            for (VehicalSlot currentSlot : currentFloor.getListOfVehicalSlots()){
                if (currentSlot.getStateOfSlot() == VehicalSlotState.FREE && currentSlot.getTypeOfVehical() == typeOfVehical){
                    return currentSlot;
                }
            }
        }
        return null;
    }
}
