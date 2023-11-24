package Models;

public class PhonePayClient extends BaseModel implements ThirdPartyClient{
    @Override
    public void makePayment() {
        System.out.println("Payment Completed Using PhonePay");
    }
}
