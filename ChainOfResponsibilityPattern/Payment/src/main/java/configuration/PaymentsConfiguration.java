package configuration;

import payment.Payment;

import java.util.ArrayList;
import java.util.List;

public class PaymentsConfiguration {
    private PaymentsConfiguration() {}

    private static List<Payment> persistence = new ArrayList<>(); // Simulate the database

    public static List<Payment> getPersistence() {
        return persistence;
    }
}
