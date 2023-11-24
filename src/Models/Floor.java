package Models;

import java.util.ArrayList;
import java.util.List;

public class Floor extends BaseModel {
    private List<VehicalSlot> listOfVehicalSlots;
    private int FloorNumber;

    private StateOfFloor floorStatus;

    public static Floor createFloor(int floorNumber, StateOfFloor floorStatus){
        Floor floor = new Floor();
        floor.FloorNumber = floorNumber;
        floor.floorStatus = floorStatus;
        floor.listOfVehicalSlots = new ArrayList<>();
        for (int i = 0;i<10;i++)
            floor.listOfVehicalSlots.add(VehicalSlot.createVehicalSlot(VehicalSlotState.FREE,floorNumber,VehicalType.CAR));
        return floor;
    }

    public boolean isEmptySlotAvailable(VehicalType typeOfVehical){
        for (VehicalSlot currentSlot : listOfVehicalSlots){
            if (currentSlot.getStateOfSlot() == VehicalSlotState.FREE && currentSlot.getTypeOfVehical() == typeOfVehical)
                return true;
        }
        return false;
    }
    public List<VehicalSlot> getListOfVehicalSlots() {
        return listOfVehicalSlots;
    }

    public void setListOfVehicalSlots(List<VehicalSlot> listOfVehicalSlots) {
        this.listOfVehicalSlots = listOfVehicalSlots;
    }

    public int getFloorNumber() {
        return FloorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        FloorNumber = floorNumber;
    }

    public StateOfFloor getFloorStatus() {
        return floorStatus;
    }

    public void setFloorStatus(StateOfFloor floorStatus) {
        this.floorStatus = floorStatus;
    }
}
