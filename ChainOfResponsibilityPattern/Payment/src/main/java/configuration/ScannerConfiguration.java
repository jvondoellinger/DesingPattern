package configuration;

import java.util.Scanner;

public class ScannerConfiguration {
    private static Scanner scanner = new Scanner(System.in).useDelimiter("\n");

    public static Scanner getInstance() {
        return scanner;
    }
}
