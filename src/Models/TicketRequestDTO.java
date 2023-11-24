package Models;

public class TicketRequestDTO {
    private VehicalType vehicalType;
    private String vehicalNumber;
    private long gateId;
    private String vehicalOwnerName;

    public VehicalType getVehicalType() {
        return vehicalType;
    }

    public void setVehicalType(VehicalType vehicalType) {
        this.vehicalType = vehicalType;
    }

    public String getVehicalNumber() {
        return vehicalNumber;
    }

    public void setVehicalNumber(String vehicalNumber) {
        this.vehicalNumber = vehicalNumber;
    }

    public String getVehicalOwnerName() {
        return vehicalOwnerName;
    }

    public void setVehicalOwnerName(String vehicalOwnerName) {
        this.vehicalOwnerName = vehicalOwnerName;
    }

    public long getGateId() {
        return gateId;
    }

    public void setGateId(long gateId) {
        this.gateId = gateId;
    }
}
