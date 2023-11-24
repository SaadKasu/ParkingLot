package Models;

public class VehicalBasedBilling extends BaseModel implements PaymentStratergy{
    @Override
    public double calculateAmount(Ticket ticket) {
        if (ticket.getVehicalSlot().getTypeOfVehical() == VehicalType.BUS)
            return 100.1;
        return 200.1;
    }
}
