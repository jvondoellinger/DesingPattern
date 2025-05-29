package tests;

import configuration.AccountsConfiguration;

public class ShowAccounts {
    public static void printAccounts() {
        for(var account : AccountsConfiguration.getPersistence()) {
            System.out.println(account);
        }
    }
}
