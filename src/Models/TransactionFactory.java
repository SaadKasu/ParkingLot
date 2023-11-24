package Models;

public class TransactionFactory {
    public static Transaction generateTransaction(ModeOfTransaction modeOfTransaction, Ticket ticket){
        if (modeOfTransaction == ModeOfTransaction.CASH){
            return new Transaction(ticket,modeOfTransaction);
        }
        else
            return new OnlineTransaction(ticket,modeOfTransaction);
    }
}
