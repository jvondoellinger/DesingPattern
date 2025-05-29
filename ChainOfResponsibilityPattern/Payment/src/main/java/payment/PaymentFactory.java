package payment;

import account.Account;

public class PaymentFactory {
    private PaymentFactory() {}

    public static Payment getInstance(Integer amount, Account origin, Account target, String message) {
        var payment = new Payment(amount, origin, target, message);
        return payment;
    }
}
