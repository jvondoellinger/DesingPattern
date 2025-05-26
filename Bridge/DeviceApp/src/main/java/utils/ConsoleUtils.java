package utils;

import configuration.ScannerConfiguration;

import java.util.Scanner;

public class ConsoleUtils {
    private ConsoleUtils() {}
    public static Integer readInt() {
        try {
            var scanner = ScannerConfiguration.getInstance();
            var text = scanner.next();
            return Integer.parseInt(text);
        } catch (RuntimeException ex) {
            return 0;
        }
    }
}
