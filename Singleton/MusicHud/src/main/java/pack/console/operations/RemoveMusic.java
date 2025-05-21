package pack.console.operations;

import pack.app.configuration.MusicStorageConfiguration;
import pack.entity.MusicBuilder;

import java.util.Scanner;

public class RemoveMusic implements OperationConsole {
    private Scanner scanner;
    public RemoveMusic(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void start() {
        System.out.println("Para seguir com a remoção da musica, é necessarios os dados abaixo: ");
        System.out.println("- Nome da musica: ");
        var name = scanner.next();
        var musicsStorage = MusicStorageConfiguration.getInstance();
        musicsStorage.removeIf(x -> x.getName().equals(name));
    }
}
