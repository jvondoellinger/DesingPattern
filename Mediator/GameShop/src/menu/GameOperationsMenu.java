package menu;

import database.repository.implementation.GameRepository;
import entity.Game;
import service.GameService;
import service.interfaces.INotification;
import utils.ScannerWrapper;

import java.util.Scanner;
import java.util.concurrent.CompletableFuture;

public class GameOperationsMenu implements IMenu {
    final static Integer ExitOption = 4;
    final Scanner scanner;
    final GameService service;
    final Game game;
    final INotification notification;
    public GameOperationsMenu(Scanner scanner, GameService service, Game game, INotification notification) {
        this.scanner = scanner;
        this.service = service;
        this.game = game;
        this.notification = notification;
    }

    @Override
    public CompletableFuture<Void> show() {
        var wrapper = new ScannerWrapper(scanner);
        System.out.println("Selecione uma operação: ");
        System.out.println(" [ 1 ] - Recomendar para alguém (email)");
        System.out.println(" [ 2 ] - Alterar algum campo");
        System.out.println(" [ 3 ] - Excluir da base de dados");
        System.out.printf(" [ %s ] - Voltar \n", ExitOption);
        var opt = wrapper.getInteger();
        return CompletableFuture.runAsync(() -> {
            if(opt == 1) {
                var email = scanner.next();
                notification.send(game.toString(), email);
            }
        });
    }


}
