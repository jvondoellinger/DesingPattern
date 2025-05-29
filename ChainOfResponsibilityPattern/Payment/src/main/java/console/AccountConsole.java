package console;

import account.Account;
import account.AccountFactory;
import configuration.AccountsConfiguration;
import configuration.ScannerConfiguration;
import exceptions.EntityNotFounded;
import tests.ShowAccounts;
import utils.ConsoleReader;

import java.util.Scanner;

public class AccountConsole implements ConsoleOperation{
    private final Scanner scanner;
    private Account account;
    public AccountConsole() {
        scanner = ScannerConfiguration.getInstance();
    }

    public void start() {
        while (true) {
            try {
                printOptions(); // Printa as opções a cada iteração!
                switchOptions();
            } catch (RuntimeException ex) {
                System.out.println(String.format("Ocorreu um erro durante a execução. \n Erro: %s \n Deseja continuar? (S/N)", ex.getMessage()));
                var text = scanner.next();
                if(text.equals("N")) {
                    throw ex;
                } else if(text.equals("S")) {
                    continue;
                } else {
                    System.out.println("Selecione S para SIM e N para NÃO!");
                }
            }

        }
    }

    private Account makeAccount() {
        System.out.println("Digite o numero da agencia");
        var agency = ConsoleReader.readInt();

        System.out.println("Digite o numero da conta");
        var account = scanner.next();

        var accountObj = AccountFactory.getInstance(agency, account);
        AccountsConfiguration.add(accountObj); // Add on "database"
        System.out.println("Conta criada com sucesso!");
        return accountObj;
    }

    private Account getAccount() {
        System.out.println("Digite o numero da agencia");
        var agency = ConsoleReader.readInt();

        System.out.println("Digite o numero da conta");
        var account = scanner.next();

        var accountObj = AccountFactory.getInstance(agency, account);
        return AccountsConfiguration.find(accountObj);
    }
    private void switchOptions() {
        int option = 0;
        switch ((option = ConsoleReader.readInt())) {
            case 0:
                System.out.println("Saindo...");
                break;
            case 1:
                account = makeAccount();
                break;
            case 2: // If there is not account selected, it will be selected!
                account = getAccount();
                break;
            case 3:
                if (account == null) {
                    System.out.println("É necessario selecionar uma conta de origem para realizar uma transferencia!");
                    break;
                }
                System.out.println("Selecione a conta destino: ");
                var target = getAccount();
                var console = ConsoleFactory.getPaymentConsole(account, target);
                console.start(); // Inicia o console de pagamentos, assim
                break;
            default:
                System.out.println("Opção invalida!");
                break;
        }
    }
    private void printOptions() {
        System.out.println("Selecione uma opção: ");
        System.out.println("[ 1 ] - Criar uma conta");
        System.out.println("[ 2 ] - Selecionar uma conta");
        System.out.println("[ 3 ] - Realizar pagamentos");
        System.out.println("[ 0 ] - Fechar");
    }


}
