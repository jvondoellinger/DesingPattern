package account;

import utils.ConsoleReader;

public class Account {
    private Integer agency;
    private String account;
    private int amount;
    protected Account(Integer agency, String account) {
        this.account = account;
        this.agency = agency;
        this.amount = 0;
    }
    protected Account(Integer agency, String account, Integer amount) {
        this.account = account;
        this.agency = agency;
        this.amount = amount;
    }

    public String getAccount() {
        return account;
    }

    protected void addAmount(Integer amount) {
        this.amount += amount;
    }
    protected void reducesAmount(Integer amount) {
        this.amount -= amount;
    }

    protected void setAccount(String account) {
        this.account = account;
    }

    public Integer getAgency() {
        return agency;
    }

    protected void setAgency(Integer agency) {
        this.agency = agency;
    }

    public int getAmount() {
        return amount;
    }

    protected void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return String.format("Account { Agency: %s, Account: %s, Amount: %s }", agency, account, amount);
    }
}
