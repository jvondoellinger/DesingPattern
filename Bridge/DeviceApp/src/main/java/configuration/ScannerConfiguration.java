package configuration;

import java.util.Scanner;

public class ScannerConfiguration {
    private static final Scanner scanner = new Scanner(System.in).useDelimiter("\n");
    private ScannerConfiguration() {}

    public static Scanner getInstance() {
        return scanner;
    }
}
