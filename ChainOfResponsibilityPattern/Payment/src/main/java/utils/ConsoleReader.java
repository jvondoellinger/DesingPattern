package utils;

import configuration.ScannerConfiguration;

import java.util.Scanner;

public class ConsoleReader {

    private ConsoleReader() {
    }
    public static Integer readInt() {
        try {
            var scanner = ScannerConfiguration.getInstance();
            var text = scanner.next();
            return Integer.parseInt(text);
        } catch (RuntimeException e) {
            return -1;
        }
    }
}
