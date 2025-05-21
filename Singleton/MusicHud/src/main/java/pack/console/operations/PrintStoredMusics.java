package pack.console.operations;

import pack.app.configuration.MusicStorageConfiguration;

import java.util.Scanner;

public class PrintStoredMusics implements OperationConsole {
    private Scanner scanner;
    public PrintStoredMusics(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void start() {
        var musics = MusicStorageConfiguration.getInstance();
        var text = "Musics [ \n";

        for(var music : musics) {
            text += "\t- "+ music.toString();
            if(musics.getLast().equals(music)) {
                text += ",";
            }
            text += "\n";
        }

        text += "]";
        System.out.println(text);
    }
}
