package pack.entity;

public class Music {
    protected Music() {}
    protected String name;

    public String getName() { return this.name; }

    @Override
    public String toString() {
        return "Music { " +
                "'" + name + '\''
                + " }";
    }
}
