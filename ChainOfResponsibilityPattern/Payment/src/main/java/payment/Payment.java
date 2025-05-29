package payment;

import account.Account;

public class Payment {
    private Integer amount;
    private String message;
    private Account origin;
    private Account target;

    protected Payment(Integer amount, Account origin, Account target, String message) {
        this.amount = amount;
        this.origin = origin;
        this.target = target;
        this.message = message;
    }


    public Account getTarget() {
        return target;
    }

    protected void setTarget(Account target) {
        this.target = target;
    }

    public Account getOrigin() {
        return origin;
    }

    protected void setOrigin(Account origin) {
        this.origin = origin;
    }

    public String getMessage() {
        return message;
    }

    protected void setMessage(String message) {
        this.message = message;
    }

    public Integer getAmount() {
        return amount;
    }

    protected void setAmount(Integer amount) {
        this.amount = amount;
    }
}
