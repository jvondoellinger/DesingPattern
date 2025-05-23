package pack.person;

public class Person {
    protected Person(String username, String registry) {
        this.username = username;
        this.registry = registry;
    }

    private String username;
    private String registry;

    public String getRegistry() {
        return registry;
    }

    public String getUsername() {
        return username;
    }
}
