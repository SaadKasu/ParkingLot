package Controllers;

import Models.ResponseStatus;
import Models.Ticket;
import Models.TicketRequestDTO;
import Models.TicketResponseDTO;
import Services.TicketService;

public class TicketController {
    TicketService ticketService;

    public TicketController(TicketService ticketService){
        this.ticketService = ticketService;
    }
    public TicketResponseDTO issueController(TicketRequestDTO request){
        TicketResponseDTO responseDTO = new TicketResponseDTO();
        try {
            Ticket ticket = ticketService.issueTicket(request.getVehicalType(), request.getVehicalNumber(), request.getVehicalOwnerName(), request.getGateId());
        }catch (Exception e){
            ResponseStatus responseStatus = new ResponseStatus();
            responseStatus.setStatus("Error");
            responseDTO.setResponseStatus(responseStatus);
            return responseDTO;
        }
        responseDTO.setResponseStatus(new ResponseStatus());
        responseDTO.getResponseStatus().setStatus("SUCCESS");
        return responseDTO;
    }
}
