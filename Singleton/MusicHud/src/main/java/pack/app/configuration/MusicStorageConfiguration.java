package pack.app.configuration;

import pack.entity.Music;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MusicStorageConfiguration {
    private MusicStorageConfiguration() {}

    private static List<Music> instance;

    public static List<Music> getInstance() {
        if(Objects.isNull(instance)) {
            synchronized (MusicStorageConfiguration.class) {
                instance = new ArrayList<>();
            }
        }
        return instance;
    }
}
