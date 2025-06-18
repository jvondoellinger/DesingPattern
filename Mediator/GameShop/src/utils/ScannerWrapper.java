package utils;

import java.math.BigDecimal;
import java.util.Scanner;

public class ScannerWrapper {
    private final Scanner scanner;

    public ScannerWrapper(Scanner scanner) {
        this.scanner = scanner;
    }
    public Integer getInteger() {
        try {
            var text = scanner.next();
            return Integer.parseInt(text);
        } catch (RuntimeException e) {
            System.out.println("Error on parsing text!");
            return 0;
        }
    }
    public BigDecimal getBigDecimal() {
        try {
            var text = scanner.next();
            return new BigDecimal(text);
        } catch (RuntimeException e) {
            System.out.println("Error on parsing text!");
            return new BigDecimal(0);
        }
    }
}
