package account;

public class AccountFactory {
    public static Account getInstance(Integer agency, String account, Integer amount) {
        return new Account(agency, account, amount);
    }
    public static Account getInstance(Integer agency, String account) {
        return new Account(agency, account);
    }
}
