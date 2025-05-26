package console;

import configuration.DevicesConfiguration;
import entity.devices.Device;

import static utils.ConsoleUtils.readInt;

public class Main {

    public static void main(String[] args) {
        System.out.println("Welcome do device manager");
        System.out.println("Please, select your device! ");
        showOptions();

        Device device = null;
        var option = 0;
        while ((option = readInt()) != 3) {
            device = null;
            switch (option) {
                case 1 -> device = DevicesConfiguration.getRadioInstance();
                case 2 -> device = DevicesConfiguration.getSoundBoxInstance();
                default -> System.out.println("Invalid option");
            }
            if(device != null) {
                var controller = ControllerFactory.getInstance(device);
                controller.start();
            }
            showOptions();
        }

    }

    private static void showOptions() {
        System.out.println(" 1 - Radio");
        System.out.println(" 2 - SoundBox");
        System.out.println(" 3 - Fechar");
    }
}
