package Models;

import java.util.Date;

public class Transaction extends BaseModel{
    public String transactionId;
    public Date dateOfTransaction;
    public ModeOfTransaction modeOfTransaction;
    private Ticket ticket;

    public Transaction(Ticket ticket, ModeOfTransaction modeOfTransaction){
        transactionId = "124";
        this.modeOfTransaction = modeOfTransaction;
        this.ticket = ticket;
    }

    public void makePayment(){
        System.out.println("Payment Completed Using Case");
    }
}
