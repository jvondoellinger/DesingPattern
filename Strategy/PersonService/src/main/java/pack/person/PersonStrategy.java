package pack.person;

public class PersonStrategy {
    private PersonStrategy() {}

    public static void validate(Person person, IValidator validator) { // Abstract validator method!
        validator.validate(person);
    }

    interface IValidator {
        void validate(Person person);
    }

    static class PhysicalPersonValidator implements IValidator {

        @Override
        public void validate(Person person) {
            if(person.getRegistry().length() != 11) {
                throw new IllegalArgumentException("Invalid physical person!");
            }
        }
    }

    static class UsernameValidator implements IValidator {
        @Override
        public void validate(Person person) {
            if(person.getUsername().length() <= 2) {
                throw new IllegalArgumentException("Invalid length username!");
            }
        }
    }

    static class LegalPersonValidator implements IValidator {
        @Override
        public void validate(Person person) {
            if (person.getRegistry().length() != 13) {
                throw new IllegalArgumentException("Invalid physical person!");
            }
        }
    }
}
