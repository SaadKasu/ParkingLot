package Models;

import Exceptions.InvalidInputException;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot extends BaseModel{
    private List<Floor> listOfFloors;
    private Gate entryGate;
    private Gate exitGate;
    private VehicalAssignmentStratergy assignmentStratergy;
    private PaymentStratergy paymentStratergy;



    public Ticket vehicalEntry(VehicalType typeOfVehical) throws NoEmptySlotsAvailableException {
        return entryGate.vehicalEntry(listOfFloors, typeOfVehical,assignmentStratergy);
    }

    public Transaction vehicalExit(Ticket ticket) throws InvalidInputException {
        return exitGate.vehicalExit(ticket, paymentStratergy);
    }


    public void setListOfFloors(List<Floor> listOfFloors) {
        this.listOfFloors = listOfFloors;
    }

    public List<Floor> getListOfFloors() {
        return listOfFloors;
    }

    public void setEntryGate(Gate entryGate) {
        this.entryGate = entryGate;
    }

    public Gate getEntryGate() {
        return entryGate;
    }

    public void setExitGate(Gate exitGate) {
        this.exitGate = exitGate;
    }

    public Gate getExitGate() {
        return exitGate;
    }


    public void setAssignmentStratergy(VehicalAssignmentStratergy assignmentStratergy) {
        this.assignmentStratergy = assignmentStratergy;
    }

    public VehicalAssignmentStratergy getAssignmentStratergy() {
        return assignmentStratergy;
    }

    public PaymentStratergy getPaymentStratergy() {
        return paymentStratergy;
    }

    public void setPaymentStratergy(PaymentStratergy paymentStratergy) {
        this.paymentStratergy = paymentStratergy;
    }

    public void initialize(){
        listOfFloors = new ArrayList<>();
        for (int i = 0;i<5;i++){
            Floor floor = Floor.createFloor(i+1,StateOfFloor.OPERATIONAL);
            listOfFloors.add(floor);
        }
        entryGate = Gate.GateFactory.build(new Gate.GateFactory("Ravi"));
        exitGate = Gate.GateFactory.build(new Gate.GateFactory("Kavi"));
        assignmentStratergy = new FirstAvailableSlot();
        paymentStratergy = new TimeBasedBilling();
    }

}
