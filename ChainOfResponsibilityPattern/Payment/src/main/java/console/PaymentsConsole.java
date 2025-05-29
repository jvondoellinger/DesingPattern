package console;

import account.Account;
import configuration.ScannerConfiguration;
import jdk.jshell.spi.SPIResolutionException;
import payment.*;
import tests.ShowAccounts;
import utils.ConsoleReader;

import java.util.Scanner;

public class PaymentsConsole implements ConsoleOperation {
    private final Scanner scanner;
    private final Account origin;
    private final Account target;

    public PaymentsConsole(Account origin, Account target) {
        this.origin = origin;
        this.target = target;
        scanner = ScannerConfiguration.getInstance();
    }

    public void start() {
        int option = -1;
        PaymentProcessor processor = null;
        while(processor == null) {
            printOptions();
            switch ((option = ConsoleReader.readInt())) {
                case 0 -> System.out.println("Saindo");
                case 1 -> processor = ProcessorFactory.getPixProcessor();
                default -> System.out.println("Opção invalida!");
            }
            var payment = make();
             //assert processor != null;
            if(processor == null) {
                continue;
            }
            processor.process(payment);
            ShowAccounts.printAccounts();
        }
    }

    private void printOptions() {
        System.out.println("Please, select a payment method: ");
        System.out.println("[ 1 ] - Pix");
        System.out.println("[ 0 ] - Fechar ");
    }

    private Payment make() {
        System.out.println("Enter the amount to be transferred: ");
        var amount = ConsoleReader.readInt();

        System.out.println("Enter your message: ");
        var message = scanner.next();
        var payment = PaymentFactory.getInstance(amount, origin, target, message);
        return payment;
    }
}
