package console;

import account.Account;

public class ConsoleFactory {
    public static ConsoleOperation getAccountConsole() {
        return new AccountConsole();
    }

    public static ConsoleOperation getPaymentConsole(Account origin, Account target) {
        return new PaymentsConsole(origin, target);
    }
}
