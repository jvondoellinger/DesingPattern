package pack.console.operations;

import java.util.Scanner;

// Lida com a fabricação da instancia!

public class OperationFactory {
    private static final Scanner scanner = new Scanner(System.in).useDelimiter("\n");

    private OperationFactory() {}

    public static OperationConsole getInitialOperation() {
        return new InitialOptions(scanner);
    }

    public static OperationConsole getAddOperation() {
        return new AddMusic(scanner);
    }

    public static OperationConsole getRemoveOperation() {
        return new RemoveMusic(scanner);
    }

    public static OperationConsole getPrintAllOperation() {
        return new PrintStoredMusics(scanner);
    }
    public static OperationConsole getUpdateOperation() {
        return new UpdateMusic(scanner);
    }
}
