package pack.entity;

public class MusicBuilder {
    private Music music;
    private MusicBuilder() {
        music = new Music();
    }
    public static MusicBuilder builder() { return new MusicBuilder(); }

    public Music build() { return this.music; } // return music

    public MusicBuilder name(String name) { // Builder set name
        this.music.name = name;
        return this;
    }
}
