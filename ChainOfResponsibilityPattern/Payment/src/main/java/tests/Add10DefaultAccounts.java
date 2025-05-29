package tests;

import account.AccountFactory;
import configuration.AccountsConfiguration;

import java.util.List;

public class Add10DefaultAccounts {
    public static void add() {
        var accounts = List.of(
            AccountFactory.getInstance(123, "1234", 501),
            AccountFactory.getInstance(124, "1234", 400),
            AccountFactory.getInstance(125, "1234", 12),
            AccountFactory.getInstance(126, "1234", 60),
            AccountFactory.getInstance(127, "1234", 500)
        );
        AccountsConfiguration.getPersistence().addAll(accounts);
    }
}
