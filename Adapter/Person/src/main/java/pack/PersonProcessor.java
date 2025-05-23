package pack;

import java.util.Objects;

public class PersonProcessor {
    public static void process(PersonAdapter adapter) {
        var ex = new IllegalArgumentException("Registry cannot be null or empty!");
        if(Objects.isNull(adapter)) {
            throw ex;
        } else if(Objects.isNull(adapter.getRegistry())) {
            throw ex;
        } else if(adapter.getRegistry().isBlank()) {
            throw ex;
        }
    }

}
