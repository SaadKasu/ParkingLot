package Models;

import java.util.Date;

public class Ticket extends BaseModel{
    public String id;

    static int counter = 1;
    public String carNumberPlate;

    private VehicalSlot vehicalSlot;

    public Date dateOfEntry;

    public Gate gateOfTicketCreation;

    public static Ticket generateTicket(VehicalSlot vehicalSlot){
        Ticket currentTicket = new Ticket();
        currentTicket.id = String.valueOf(counter++);
        currentTicket.setCarNumberPlate("1234");
        currentTicket.setVehicalSlot(vehicalSlot);
        return currentTicket;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCarNumberPlate() {
        return carNumberPlate;
    }

    public void setCarNumberPlate(String carNumberPlate) {
        this.carNumberPlate = carNumberPlate;
    }

    public VehicalSlot getVehicalSlot() {
        return vehicalSlot;
    }

    public void setVehicalSlot(VehicalSlot vehicalSlot) {
        this.vehicalSlot = vehicalSlot;
    }

    public Date getDateOfEntry() {
        return dateOfEntry;
    }

    public void setDateOfEntry(Date dateOfEntry) {
        this.dateOfEntry = dateOfEntry;
    }

    public Gate getGateOfTicketCreation() {
        return gateOfTicketCreation;
    }

    public void setGateOfTicketCreation(Gate gateOfTicketCreation) {
        this.gateOfTicketCreation = gateOfTicketCreation;
    }
}
