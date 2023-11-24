package Models;

public class VehicalSlot extends BaseModel{
    private VehicalSlotState stateOfSlot;
    private int floorNumber;

    private VehicalType typeOfVehical;

    public static VehicalSlot createVehicalSlot(VehicalSlotState vehicalSlotState, int floorNumber, VehicalType vehicalType){
        VehicalSlot vehicalSlot = new VehicalSlot();
        vehicalSlot.stateOfSlot = vehicalSlotState;
        vehicalSlot.typeOfVehical = vehicalType;
        vehicalSlot.floorNumber = floorNumber;
        return vehicalSlot;
    }

    public VehicalSlotState getStateOfSlot() {
        return stateOfSlot;
    }

    public void setStateOfSlot(VehicalSlotState stateOfSlot) {
        this.stateOfSlot = stateOfSlot;
    }

    public VehicalType getTypeOfVehical() {
        return typeOfVehical;
    }

    public void setTypeOfVehical(VehicalType typeOfVehical) {
        this.typeOfVehical = typeOfVehical;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }
}
