package Models;

public class OnlineTransaction extends Transaction{
    private ThirdPartyClient onlineClient;

    public OnlineTransaction(Ticket ticket, ModeOfTransaction modeOfTransaction){
        super(ticket,modeOfTransaction);
        onlineClient = new PhonePayClient();
    }

    public void makePayment(){
        onlineClient.makePayment();
    }

    public void setOnlineClient(ThirdPartyClient onlineClient) {
        this.onlineClient = onlineClient;
    }
}
