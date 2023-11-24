package Client;

import java.util.Date;

public class ClientController {
    public static void main(String[] args) {
        /*
        ParkingLotController parkingLotController = new ParkingLotController();
        ParkingLot parkingLot = parkingLotController.getParkingLot();
        Ticket tic1 = null, tic2 = null;
        try {
            tic1 = parkingLotController.vehicalEntry(parkingLot, VehicalType.CAR);
        }
        catch (NoEmptySlotsAvailableException e){
            System.out.println("No Slots available");
        }
        System.out.println(tic1.id);
        try {
            tic2 = parkingLotController.vehicalEntry(parkingLot, VehicalType.BUS);
        }
        catch (NoEmptySlotsAvailableException e){
            System.out.println("No Slots available");
        }
        Transaction trac1 = null, trac2 = null;
        try{
            trac1 = parkingLotController.vehicalExit(parkingLot,tic1);
        }
        catch (InvalidInputException e){
            System.out.println("Please Enter a valid input");
        }
        try{
            trac2 = parkingLotController.vehicalExit(parkingLot,tic1);
        }
        catch (InvalidInputException e){
            System.out.println("Please Enter a valid input");
        }
        try{
            trac2 = parkingLotController.vehicalExit(parkingLot,tic1);
        }
        catch (InvalidInputException e){
            System.out.println("Please Enter a valid input");
        }

        System.out.println(trac1.transactionId);
         */
        System.out.println(new Date());
    }
}
