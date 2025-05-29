package payment;

public class PixProcessor extends PaymentProcessor {
    public PixProcessor() {
    }
    @Override
    protected void handle(Payment p) {
        System.out.println("Value: " + p.getAmount());
    }
}
