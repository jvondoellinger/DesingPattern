package console;

import tests.Add10DefaultAccounts;

public class Start {

    public static void main(String[] args) {
        Add10DefaultAccounts.add();
        System.out.println("Welcome to payment system!");
        var console = ConsoleFactory.getAccountConsole();
        try {
            console.start();
        } catch (RuntimeException ex) {
            System.out.println("Houve um erro durante a execução da aplicação!");
            System.out.println(String.format("Erro: %s", ex.getMessage()));
        }
    }

}
