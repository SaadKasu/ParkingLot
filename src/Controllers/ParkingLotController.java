package Controllers;

import Exceptions.InvalidInputException;
import Models.*;

public class ParkingLotController {

        public ParkingLot getParkingLot(){
            ParkingLot parkingLot = new ParkingLot();
            parkingLot.initialize();
            return parkingLot;
        }
        public Ticket vehicalEntry(ParkingLot parkingLot, VehicalType typeOfVehical) throws NoEmptySlotsAvailableException {
            Ticket ticket = parkingLot.vehicalEntry(typeOfVehical);
            return ticket;
        }
        public Transaction vehicalExit(ParkingLot parkingLot, Ticket ticket) throws InvalidInputException {
            return parkingLot.vehicalExit(ticket);
        }
}
