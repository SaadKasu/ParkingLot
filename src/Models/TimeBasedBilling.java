package Models;

import java.sql.Date;
import java.sql.Time;
import java.time.ZonedDateTime;

public class TimeBasedBilling extends BaseModel implements PaymentStratergy{
    @Override
    public double calculateAmount(Ticket ticket) {
        return 0d;
    }
}
