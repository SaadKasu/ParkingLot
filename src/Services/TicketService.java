package Services;

import Controllers.TicketController;
import Exceptions.GateNotFoundException;
import Models.*;
import Repository.GateRepository;
import Repository.ParkingLotRepository;
import Repository.TicketRepository;
import Repository.VehicalRepository;

import java.util.Date;
import java.util.Optional;

public class TicketService {
    private GateRepository gateRepository;
    private ParkingLotRepository parkingLotRepository;
    private TicketRepository ticketRepository;

    TicketService(GateRepository gateRepository, ParkingLotRepository parkingLotRepository, TicketRepository ticketRepository){
        this.gateRepository = gateRepository;
        this.ticketRepository = ticketRepository;
        this.parkingLotRepository = parkingLotRepository;
    }
    public Ticket issueTicket(VehicalType type, String vehicalNumber, String vehicalOwnerName, Long gateId) throws GateNotFoundException {
        Optional<Gate> optionalGate = gateRepository.findGateById(gateId);
        if (optionalGate.isEmpty())
            throw new GateNotFoundException();
        Gate gate = optionalGate.get();

        Ticket ticket = new Ticket();
        ticket.setGateOfTicketCreation(gate);
        ticket.setDateOfEntry(new Date());
        Optional<Vehical> wrappedVehical = VehicalRepository.getVehicalByNumberPlate(vehicalNumber);
        if (wrappedVehical.isEmpty()){
            Vehical vehical = new Vehical();
            vehical.setVehicalType(type);
            vehical.setNumberPlate(vehicalNumber);
            vehical.setOwnerName(vehicalOwnerName);
            VehicalRepository.saveVehicalInDB(vehical);
        }
        wrappedVehical = VehicalRepository.getVehicalByNumberPlate(vehicalNumber);
        Vehical returnedVehical = wrappedVehical.get();

        // Now to assign the parking spot. Get the parking lot because parking lot has the stratergy used to
        //assign the spot.

        //Get parking lot using the Gate reference.
        Optional<ParkingLot> wrappedParkingLot = parkingLotRepository.getParkingLotForGate(ticket.getGateOfTicketCreation());

        ParkingLot parkingLot = wrappedParkingLot.get();
        VehicalAssignmentStratergy stratergy = parkingLot.getAssignmentStratergy();
        ticket.setVehicalSlot(stratergy.assignSlot(parkingLot.getListOfFloors(),type));
        ticketRepository.saveTicketToDB(ticket);
        return ticket;
    }

}
