package menu;

import anootation.BadCode;
import entity.Game;
import entity.GameBuilder;
import service.GameService;
import utils.ScannerWrapper;

import java.util.Objects;
import java.util.Scanner;
import java.util.concurrent.CompletableFuture;

public class GameMenu implements IMenu {
    private final Scanner scanner;
    private final GameService service;

    public GameMenu(Scanner scanner, GameService service) {
        this.scanner = scanner;
        this.service = service;
    }

    @Override
    @BadCode // builder().build() - no validations
    // Will be used Chain Of Responsibility and Strategy pattern to validate the entity!
    public CompletableFuture<Void> show() {
        var wrapper = new ScannerWrapper(scanner);
            int opt = -1;
            int exitNum = 4;
            CompletableFuture<Void> future = null; // Inicializando em null
            System.out.println("*********************************************");

            System.out.println("Select a option:");
            System.out.println("[ 1 ] - Select a existing game ");
            System.out.println("[ 2 ] - Show all existing game ");
            System.out.println("[ 3 ] - Add new game ");
            System.out.printf("[ %s ] - Exit \n", exitNum);

            while ((opt = wrapper.getInteger()) != exitNum) {
                // Captura um CompletableFuture<> conforme a opção selecionada!!
                future = switch (opt) {
                    case 1 -> findAndPrint();
                    case 2 -> findAllAndPrint();
                    case 3 -> create(wrapper);
                    default -> null;
                };
                // Validando a opção será validada aqui!
                if(Objects.isNull(future)) {
                    System.out.println("invalid Option!");
                }
            }
        System.out.println("Exiting..."); // Saindo desse menu!
        return future; // Caso não possua opção valida, vai dar erro. Preciso corrigir isso depois!
    }

    private CompletableFuture<Void> findAndPrint() {
        return CompletableFuture.runAsync(() -> {
            service.get(scanner.next()).subscribe(System.out::println);
        });
    }
    private CompletableFuture<Void> findAllAndPrint() {
        return CompletableFuture.runAsync(() -> {
            service.get().subscribe(System.out::println);
        });
    }
    private CompletableFuture<Void> create(ScannerWrapper wrapper) {
        return CompletableFuture.runAsync(() -> {
            service.add(maker(wrapper)).subscribe();
        });
    }

    public Game maker(ScannerWrapper wrapper) {
        var builder = GameBuilder.builder();
        System.out.println("To proceed on this action, please provide the details below: ");

        var name = wrapper.printGet("Name: ", scanner::next);
        var description = wrapper.printGet("Description: ", scanner::next);
        var price = wrapper.printGet("Price: ", wrapper::getBigDecimal);

        return builder
                .name(name)
                .description(description)
                .price(price)
                .build();
    }

}

