import pack.Pizza;
import pack.PizzaFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Pizza> selectedPizzas = new ArrayList<>();
    private static final double unitValue = 49.99;

    private static Scanner scanner = new Scanner(System.in);

    private static void showOptions() {
        System.out.println("""
                1- Chocolate 
                2- Mussarela
                3- Peperone
                4- Preparar
                5- Cancelar
                6- Parar aplicação!
                """);
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.printf("Hello and welcome!");
        System.out.println("Selecione um sabor de pizza");

        showOptions();

        int option = readInt();
        Pizza selectedPizza = null;
        while(option != 6) {
            switch (option) {
                case 1:
                    selectedPizza = PizzaFactory.getChocolatePizza();
                    System.out.println(selectedPizza);
                    selectedPizzas.add(selectedPizza);
                    break;
                case 2:
                    selectedPizza = PizzaFactory.getMucarelaPizza();
                    System.out.println(selectedPizza);
                    selectedPizzas.add(selectedPizza);
                    break;
                case 3:
                    selectedPizza = PizzaFactory.getPeperonePizza();
                    System.out.println(selectedPizza);
                    selectedPizzas.add(selectedPizza);
                    break;
                case 4:
                    System.out.println("Quantidade de pizzas: "+ selectedPizzas.stream().count());
                    System.out.println("Valor total: "+ selectedPizzas.stream().count() * unitValue);
                    System.out.println("Wait, preparing yours pizza...");
                    Thread.sleep(1000);
                    System.out.println("Ready pizza!");
                    selectedPizzas.clear();
                    System.out.println("You can do more orders, will show the options again!");
                    showOptions();
                    break;
                case 5:
                    if(selectedPizzas.stream().count() == 0) {
                        System.out.println("Cannot cancel a empty order!");
                        break;
                    }
                    System.out.println("Quantidade de pizzas: "+ selectedPizzas.stream().count());
                    System.out.println("Valor total: "+ selectedPizzas.stream().count() * unitValue);
                    System.out.println("Wait, canceling your order...");
                    Thread.sleep(1000);
                    System.out.println("Ready!");
                    System.out.println("You can do more orders, will show the options again!");
                    showOptions();
                    break;
                default:
                    System.out.println("Opção inválida!");
            }

            option = readInt();
        }

    }

    private static int readInt() {
        try{
            return Integer.parseInt(scanner.nextLine());
        } catch (RuntimeException e) {
            System.out.println("Invalid input - text is not allowed!");
            return 0;
        }
    }
}