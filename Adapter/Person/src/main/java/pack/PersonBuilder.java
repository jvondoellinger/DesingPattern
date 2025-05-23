package pack;

public class PersonBuilder {
    private PhysicalPerson physicalPerson;
    private PersonBuilder() {
        physicalPerson = new PhysicalPerson();
    }

    public PhysicalPerson build() { return physicalPerson; }

    public PersonBuilder username(String username) {
        physicalPerson.setUsername(username);
        return this;
    }
    public PersonBuilder registry(String registry) {
        physicalPerson.setCpf(registry);
        return this;
    }



    public static PersonBuilder builder() {
        return new PersonBuilder();
    }
}
