
abstract class Payment{
    private double amount;

    public Payment(double amount){
        this.amount = amount;
    }

    void receipt(){
        System.out.println("Receipt: Processing payment of $" + amount + ".");
    }

    abstract void authorizePayment();

}

class CreditCardPayment extends Payment{

    public CreditCardPayment(double amount){
        super(amount);
    }

    @Override
    public void authorizePayment(){
        System.out.println("Authorizing Credit Card charge via Bank Gateway. . .");
    }

}

class PayPalPayment extends Payment{

    public PayPalPayment(double amount){
        super(amount);
    }
@Override
public void authorizePayment(){
    System.out.println("Redirecting to Paypal login for verification. . .");
}

}

public class Abstract {
    public static void main(String[] args) {


        CreditCardPayment cardPay = new CreditCardPayment(89.99);
        cardPay.receipt();
        cardPay.authorizePayment();

        System.out.println("-----------------------------------");


        PayPalPayment paypalPay = new PayPalPayment(25.50);
        paypalPay.receipt();
        paypalPay.authorizePayment();

    }
}