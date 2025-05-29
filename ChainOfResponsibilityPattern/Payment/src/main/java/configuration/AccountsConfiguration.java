package configuration;

import account.Account;
import exceptions.EntityNotFounded;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class AccountsConfiguration {
    private AccountsConfiguration() {}

    private static List<Account> persistence = new ArrayList<>();// Simulates the database...

    public static List<Account> getPersistence() {
        return persistence;
    }

    public static void add(Account account) {
        persistence.add(account);
    }

    public static Account find(Account account) {
        return persistence.stream()
                .filter(x ->
                    x.getAccount().equals(account.getAccount()) && x.getAgency().equals(account.getAgency())
                )
                .findFirst()
                .orElseThrow(EntityNotFounded::new);
    }

    public static Account find(Predicate<? super Account> supplier) {
        return persistence.stream()
                .filter(supplier)
                .findFirst()
                .orElseThrow(EntityNotFounded::new);
    }
}
