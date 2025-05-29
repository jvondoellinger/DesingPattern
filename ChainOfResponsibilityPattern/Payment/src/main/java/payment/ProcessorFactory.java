package payment;

import account.AccountProcessor;

public class ProcessorFactory {
    public static PaymentProcessor getPixProcessor() {
        var process = new PixProcessor();
        process.setNext(new AccountProcessor());
        return process;
    }
}
