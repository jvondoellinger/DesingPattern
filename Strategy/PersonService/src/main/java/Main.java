import pack.person.PersonFactory;
import pack.person.PersonStrategy;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in).useDelimiter("\n");

    private static Integer readInt() {
        try {
            var read = scanner.next();
            return Integer.parseInt(read);
        } catch (RuntimeException ex) {
            return 0;
        }
    }

    public static void main(String[] args) {
        printOptions();
        var option = readInt();
        while (option != 3) {
            switch (option) {
                case 1 -> caseCpf();
                case 2 -> caseCnpj();
                default -> System.out.println("Invalid option");
            }
            printOptions();
            option = readInt();
        }
        scanner.close();
        System.out.println("Finalizando aplicação...");
    }
    private static void caseCnpj() {
        System.out.println("Digite a razão social da empresa: ");
        var username = scanner.next();
        System.out.println("Digite seu CNPJ: ");
        var cpf = scanner.next();
        var person = PersonFactory.getLegalPerson(username, cpf);
        System.out.println("Pessoa verificada!");
    }
    private static void caseCpf() {
        System.out.println("Digite seu Nome completo: ");
        var username = scanner.next();
        System.out.println("Digite seu CPF: ");
        var cpf = scanner.next();
        var person = PersonFactory.getPhysicalPerson(username, cpf);
        System.out.println("Pessoa verificada!");
    }

    private static void printOptions() {
        System.out.println("Seja bem vindo!");
        System.out.println("Digite: 1 - para pessoa fisica");
        System.out.println("Digite: 2 - para pessoa juridica");
        System.out.println("Digite: 3 - para fechar a aplicação");
    }
}
