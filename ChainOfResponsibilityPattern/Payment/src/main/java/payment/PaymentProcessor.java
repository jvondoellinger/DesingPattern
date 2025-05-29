package payment;

import java.util.PropertyResourceBundle;

public abstract class PaymentProcessor {
    private PaymentProcessor next;

    public void setNext(PaymentProcessor processor) {
        if(next == null) {
            next = processor;
        } else {
            next.setNext(processor);
        }
    }

    public Payment process(Payment payment) {
        System.out.println("Processing");
        handle(payment);
        if(next != null) {
            return next.process(payment);
        } else {
            return payment;
        }
    }

    protected abstract void handle(Payment p);
}
