package pack.console.operations;

import pack.app.configuration.MusicStorageConfiguration;
import pack.entity.MusicBuilder;

import java.util.Scanner;

public class AddMusic implements OperationConsole {
    private Scanner scanner;
    public AddMusic(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void start() {
        System.out.println("Para seguir com a adição da musica, é necessarios os dados abaixo: ");
        System.out.println("- Nome da musica: ");
        var name = scanner.next();
        var musicsStorage = MusicStorageConfiguration.getInstance();
        var music = MusicBuilder.builder()
                .name(name)
                .build();
        musicsStorage.add(music);
    }
}
