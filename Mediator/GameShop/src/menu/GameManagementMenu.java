package menu;

import anootation.BadCode;
import entity.Game;
import entity.GameBuilder;
import service.GameService;
import utils.ScannerWrapper;

import javax.sound.midi.Soundbank;
import java.util.Scanner;
import java.util.concurrent.CompletableFuture;

public class GameManagementMenu implements IMenu {
    private final Scanner scanner;
    private final GameService service;

    public GameManagementMenu(Scanner scanner, GameService service) {
        this.scanner = scanner;
        this.service = service;
    }

    @Override
    @BadCode // builder().build() - no validations
    // Will be used Chain Of Responsibility and Strategy pattern to validate the entity!
    public CompletableFuture<Void> show() {
        var wrapper = new ScannerWrapper(scanner);
        var future = CompletableFuture.runAsync(() -> {
            int opt = -1;
            int exitNum = 4;
            while (opt != exitNum) {
                System.out.println("*********************************************");
                System.out.println("Select a option:");
                System.out.println("[ 1 ] - Select a existing game ");
                System.out.println("[ 2 ] - Show all existing game ");
                System.out.println("[ 3 ] - Add new game ");
                // System.out.println("[ 3 ] - Show all sold games "); Another menu
                System.out.printf("[ %s ] - Exit \n", exitNum);

                // Base code
                switch (opt) {
                    case 1 -> service.get(scanner.next());
                    case 2 -> service.get();
                    case 3 -> service.add(maker(wrapper));
                    default -> System.out.println("Invalid option");
                };
                opt = wrapper.getInteger();
            }
        });
        System.out.println("Exiting...");
        return future;
    }
    public Game maker(ScannerWrapper wrapper) {
        var builder = GameBuilder.builder();
        System.out.println("To proceed on this action, please provide the details below: ");
        System.out.printf("Name: ");
        var name = scanner.next();
        System.out.printf("Description: ");
        var description = scanner.next();
        System.out.printf("Price: ");
        var price = wrapper.getBigDecimal(); // Wrapper use the scanner to get this value!
        return builder
                .name(name)
                .description(description)
                .price(price)
                .build();
    }
}

