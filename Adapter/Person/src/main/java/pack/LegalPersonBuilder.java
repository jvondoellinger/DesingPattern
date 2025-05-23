package pack;

public class LegalPersonBuilder {
    private LegalPerson legalPerson;
    private LegalPersonBuilder() {
        legalPerson = new LegalPerson();
    }

    public LegalPerson build() { return legalPerson; }

    public LegalPersonBuilder username(String username) {
        legalPerson.setUsername(username);
        return this;
    }
    public LegalPersonBuilder registry(String registry) {
        legalPerson.setCnpj(registry);
        return this;
    }



    public static LegalPersonBuilder builder() {
        return new LegalPersonBuilder();
    }
}
