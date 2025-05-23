package pack;

public class PersonFactory {
    private PersonFactory() {}

    public static LegalPerson getLegalPerson(String username, String registry) {
        var person = LegalPersonBuilder.builder()
                .username(username)
                .registry(registry)
                .build();
        PersonProcessor.process(person);
        return person;
    }
    public static PhysicalPerson getPhysicalPerson(String username, String registry) {
        var person = PersonBuilder.builder()
                .username(username)
                .registry(registry)
                .build();
        PersonProcessor.process(person);
        return person;
    }

}
