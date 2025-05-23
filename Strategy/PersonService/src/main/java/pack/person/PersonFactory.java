package pack.person;

public class PersonFactory {
    private PersonFactory() {}

    private static Person getPerson(String username, String registry, PersonStrategy.IValidator personValidator) {
        var person = new Person(username, registry);
        PersonStrategy.validate(person, personValidator);
        PersonStrategy.validate(person, new PersonStrategy.UsernameValidator());
        return person;
    }

    public static Person getPhysicalPerson(String username, String registry) {
        return getPerson(username, registry, new PersonStrategy.PhysicalPersonValidator());
    }

    public static Person getLegalPerson(String username, String registry) {
        return getPerson(username, registry, new PersonStrategy.LegalPersonValidator());
    }
}
