package console;

import pack.BurgerFactory;
import pack.Burguer;
import pack.Food;
import pack.HotDogFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Start {
    private static final Scanner scanner = new Scanner(System.in).useDelimiter("\n");
    private static List<Food> order = new ArrayList<>();


    static class Utils {
        int readInt() {
            try{
                 var text = scanner.next();
                 return Integer.parseInt(text);
            } catch (RuntimeException e) {
                return -1;
            }
        }
    }

    public static void main(String[] args) {
        var util = new Utils();
        System.out.println("Welcome to food-hub!");

        System.out.println("Please, make your order!");
        printOptions();
        int option;
        while ((option = util.readInt()) != 0) {
            Food food = null;
            switch (option) {
                case -1:
                    System.out.println("fudeo");
                    break;
                case 1:
                    food =new HotDogFactory().getFood();
                    break;
                case 2:
                    food = new BurgerFactory().getFood();
                    break;
                case 3:
                    printOrder();
                    break;
                case 4:
                    printOrder();
                    System.out.println("Select the index, showed in this order!");
                    var index = util.readInt();
                    if(index > order.size() -1 || index == -1) {
                        System.out.println("Invalid number");
                        break;
                    }
                    System.out.println("Qual ingrediente você deseja adicionar?");
                    var ingredient = scanner.next();
                    order.get(index).addIngredient(ingredient);
                    System.out.printf("Ingredient: %s added \n", ingredient);
                    break;
                case 5:
                    printOrder();
                    System.out.println("Select the index, showed in this order!");
                    var index2 = util.readInt();
                    if(index2 > order.size() || index2 == -1) {
                        System.out.println("Invalid number");
                        break;
                    }
                    System.out.println("Qual ingrediente você deseja removed?");
                    var ingredient2 = scanner.next();
                    order.get(index2).removeIngredient(ingredient2);
                    System.out.printf("Ingredient: %x added \n", ingredient2);
                    break;
                case 6:
                    printOrder();
                    System.out.println("Processing payment...");
                    System.out.println("Accepted!");
                    System.out.println("Order closed!");
                    break;
                default:
                    System.out.println("Invalid option");
            };
            if(food != null) {
                order.add(food);
            }

        }


    }

    private static void printOptions() {
        System.out.println("1 - HotDog");
        System.out.println("2 - Burguer");
        System.out.println("3 - Show order");
        System.out.println("4 - Add Ingredient");
        System.out.println("5 - Remove Ingredient");
        System.out.println("6 - Finish order");
        System.out.println("7 - Exit");
    }

    private static void printOrder() {
        String text = "Order [ \n";
        for (var food : order) {
            var index = order.indexOf(food);
            text += String.format("%s - %s \n", index, food);
        }
        text += "]";
        System.out.println(text);;
    }
}
