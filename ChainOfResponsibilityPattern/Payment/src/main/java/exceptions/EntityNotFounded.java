package exceptions;

public class EntityNotFounded extends RuntimeException {
    public EntityNotFounded(String message) {
        super(message);
    }
    public EntityNotFounded(String message, Exception ex) {
        super(message, ex);
    }
    public EntityNotFounded() {
        super("Entity not found!");
    }
}
