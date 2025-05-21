package pack.console.operations;

import pack.app.configuration.MusicStorageConfiguration;
import pack.entity.MusicBuilder;

import java.util.Scanner;

public class UpdateMusic implements OperationConsole {
    private Scanner scanner;
    public UpdateMusic(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void start() {
        var musics = MusicStorageConfiguration.getInstance();
        System.out.println("Informe o nome da musica a ser atualizada: ");
        var nameToRemove = scanner.next();
        musics.removeIf(x -> x.getName().equals(nameToRemove));
        System.out.println("Informe o novo nome da musica: ");
        var newName = scanner.next();
        var music = MusicBuilder.builder()
                .name(newName)
                .build();
        musics.add(music);
    }
}
