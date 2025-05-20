import pack.User;
import pack.UserBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    private static List<User> users = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in).useDelimiter("\n");


    class PrintUtils {

        private static void printOptions() {
            System.out.println("""
                1- Criar usuarios
                2- Contar usuarios
                3- Mostrar usuarios cadastrados
                4- Finalizar
                """);
        }
        private static void printUsers() {
            var string = "Users [";
            for (var user : users) {
                string += String.format("User: { Username: %s \n Email: %s \n Password: %s " ,
                        user.getUsername(), user.getEmail(), user.getPassword());
                string += " }, \n";
                if(users.getLast().equals(user)){
                    string += " ]";
                }
            }
            System.out.println(string);
        }
    }



    private static User make() {
        System.out.println("\nNome de usuario: ");
        var username = scanner.next();
        System.out.println("\nEmail do usuario: ");
        var email = scanner.next();
        System.out.println("\nPassword do usuario: ");
        var password = scanner.next();

        var userBuilder = UserBuilder.builder()
                .username(username)
                .email(email)
                .password(password);
        return userBuilder.build();
    }

    private static boolean validate(User user) {
        System.out.println("Confirme os dados abaixo: ");
        System.out.println("Nome de usuario: " + user.getUsername());
        System.out.println("Email do usuario: " + user.getEmail());
        System.out.println("Password do usuario: " + user.getPassword());
        System.out.println("\nConfirma os dados?");
        System.out.println(" ( 1 ) - Sim");
        System.out.println(" ( 2 ) - Não");
        Boolean valid = null;
        while (valid == null) {
            var response = readInt();
            switch (response) {
                case 1:
                    System.out.println("Aceitou");
                    valid = true;
                    break;
                case 2:
                    valid = false;
                    break;
                default:
                    System.out.println("Opção invalida!");
                    break;
            }
        }
        System.out.println("finalizou");
        return valid;
    }

    public static void main(String[] args) {
        System.out.println("Selecione uma das opções abaixo: ");
        PrintUtils.printOptions();
        var selectedOption = readInt();
        while (selectedOption != 4) {
            switch (selectedOption) {
                case 1:
                    var user = make();
                    if(validate(user)) {
                        System.out.println("Usuario adicionado!");
                        users.add(user);
                    } else {
                        System.out.println("Usuario não adicionado, devido aos dados não terem sidos confirmados!23");
                    }
                    PrintUtils.printOptions();
                    break;
                case 2:
                    System.out.println("Numero de usuarios: "+ users.stream().count());
                    break;
                case 3:
                    PrintUtils.printUsers();
                    PrintUtils.printOptions();
                    break;
                default:
                    System.out.println("Opção invalida!");
                    PrintUtils.printOptions();
                    break;
            }
            selectedOption = readInt();
        }
        System.out.println("Saíndo...");
        System.out.println("Até a próxima!");
    }

    private static int readInt() {
        try {
            return Integer.parseInt(scanner.next());
        } catch (RuntimeException e) {
            return 0;
        }
    }

}