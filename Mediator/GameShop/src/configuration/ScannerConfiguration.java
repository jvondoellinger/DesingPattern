package configuration;

import java.util.Objects;
import java.util.Scanner;

public class ScannerConfiguration {
    private ScannerConfiguration() {}

    private static Scanner scanner;
    public static Scanner getInstance() {
        if(Objects.isNull(scanner)) {
            scanner = new Scanner(System.in).useDelimiter("\n");
        }
        return scanner;
    }
}
