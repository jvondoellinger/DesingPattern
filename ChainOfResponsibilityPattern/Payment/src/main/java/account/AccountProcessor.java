package account;

import configuration.AccountsConfiguration;
import payment.Payment;
import payment.PaymentProcessor;

public class AccountProcessor extends PaymentProcessor {

    @Override
    protected void handle(Payment p) {
        if(p.getAmount() > p.getOrigin().getAmount()){
            throw new IllegalArgumentException("Insufficient balance!");
        }
        addToTarget(p);
        reduceToOrigin(p);
    }

    private void addToTarget(Payment p) {
        var account = AccountsConfiguration.find(p.getTarget());
        account.addAmount(p.getAmount()); // Adiciona um valor na contar destino!
    }
    private void reduceToOrigin(Payment p) {
        var account = AccountsConfiguration.find(p.getOrigin());
        account.reducesAmount(p.getAmount()); // Retira da conta de origem!
    }
}
