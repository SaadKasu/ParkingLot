package Models;

import Exceptions.InvalidInputException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Gate extends BaseModel{
    private String operatorName;

    private List<Transaction> listOfTransactions;

    private List<Ticket> listOfTickets;

    public Gate(){}

    public Gate(GateFactory gateFactory){
        this.operatorName = gateFactory.operatorName;
        this.listOfTickets = gateFactory.listOfTickets;
        this.listOfTransactions = gateFactory.listOfTransactions;
    }

    public List<Transaction> getListOfTransactions(){
        return this.listOfTransactions;
    }

    public static class GateFactory{
        private String operatorName;

        private List<Transaction> listOfTransactions;

        private List<Ticket> listOfTickets;

        public GateFactory(String operatorName){
            this.operatorName = operatorName;
            listOfTickets = new ArrayList<>();
            listOfTransactions = new ArrayList<>();
        }

        public static Gate build(GateFactory factory){
            Gate gate = new Gate(factory);
            return gate;
        }
    }

    public Transaction vehicalExit(Ticket ticket, PaymentStratergy paymentStratergy) throws InvalidInputException{
        freeVehicalSlot(ticket);
        double amount = paymentStratergy.calculateAmount(ticket);
        System.out.println("Your total amount is - "+amount + ". How would you like to make the payment ? \n1.)Cash\n2.)Online");
        int input = new Scanner(System.in).nextInt();
        if (input != 1 && input != 2)
            throw new InvalidInputException();
        ModeOfTransaction modeOfTransaction = input == 1 ? ModeOfTransaction.CASH : ModeOfTransaction.ONLINE;
        Transaction currentTransaction = TransactionFactory.generateTransaction(modeOfTransaction, ticket);
        currentTransaction.makePayment();
        listOfTransactions.add(currentTransaction);
        return currentTransaction;
    }

    private void freeVehicalSlot(Ticket ticket){
        VehicalSlot slot = ticket.getVehicalSlot();
        slot.setStateOfSlot(VehicalSlotState.FREE);
    }



    public Ticket vehicalEntry(List<Floor> listOfFloors,VehicalType typeOfVehical, VehicalAssignmentStratergy assignmentStratergy) throws NoEmptySlotsAvailableException {
        VehicalSlot currentVehicalSlot = assignVehicalSlot(listOfFloors,typeOfVehical, assignmentStratergy);
        Ticket ticket = Ticket.generateTicket(currentVehicalSlot);
        ticket.setGateOfTicketCreation(this);
        listOfTickets.add(ticket);
        return ticket;
    }

    public boolean isEmptySlotAvailable(List<Floor> listOfFloors, VehicalType typeOfVehical){
        for(Floor currentFloor : listOfFloors){
            if (currentFloor.getFloorStatus() == StateOfFloor.OPERATIONAL && currentFloor.isEmptySlotAvailable(typeOfVehical))
                return true;
        }
        return false;
    }

    public VehicalSlot assignVehicalSlot(List<Floor> listOfFloors, VehicalType typeOfVehical,VehicalAssignmentStratergy assignmentStratergy) throws NoEmptySlotsAvailableException {
        if (!isEmptySlotAvailable(listOfFloors, typeOfVehical))
            throw new NoEmptySlotsAvailableException();
        return assignmentStratergy.assignSlot(listOfFloors, typeOfVehical);
    }

    public String getOperatorName() {
        return operatorName;
    }


    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public void setListOfTransactions(List<Transaction> listOfTransactions) {
        this.listOfTransactions = listOfTransactions;
    }

    public void setListOfTickets(List<Ticket> listOfTickets) {
        this.listOfTickets = listOfTickets;
    }
}
