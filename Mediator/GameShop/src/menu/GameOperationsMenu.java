package menu;

import database.repository.implementation.GameRepository;
import entity.Game;
import service.impl.email.EmailNotification;

import java.util.concurrent.CompletableFuture;

public class GameOperationsMenu implements IMenu {
    private final static Integer ExitOption = 4;
    private final GameRepository repository;
    public final Game game;
    public GameOperationsMenu(GameRepository repository, Game game) {
        this.repository = repository;
        this.game = game;
    }
    @Override
    public CompletableFuture<Void> show() {
        System.out.println("Selecione uma operação: ");
        System.out.println(" [ 1 ] - Recomendar para alguém (email)");
        System.out.println(" [ 2 ] - Alterar algum campo");
        System.out.println(" [ 3 ] - Excluir da base de dados");
        System.out.printf(" [ %s ] - Voltar \n", ExitOption);


        return null;
    }


}
