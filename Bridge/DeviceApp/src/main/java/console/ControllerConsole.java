package console;

import entity.controller.AdvancedRemoteController;
import entity.controller.RemoteController;
import entity.devices.Device;
import utils.ConsoleUtils;

public class ControllerConsole {
    private final Device device;

    public ControllerConsole(Device device) {
        this.device = device;
    }

    public void start() {
        System.out.println("Selecione o tipo de controle: ");
        System.out.println("1 - Básico ");
        System.out.println("2 - Avançado ");
        System.out.println("3 - Sair ");
        switch (ConsoleUtils.readInt()){
            case 1 -> basicController();
            case 2 -> advancedController();
            default -> System.out.println("Invalid Option");
        }
    }

    private void basicOptions() {
        System.out.println("Selecione uma opção:");
        System.out.println("1 - Ligar");
        System.out.println("2 - Desligar");
        System.out.println("3 - Aumentar volume");
        System.out.println("4 - Diminuir volume");
    }
    private void advancedOptions() {
        basicOptions();
        System.out.println("5 - Mutar");
        System.out.println("6 - Desmutar");
    }
    private void basicController() {
        var controller = new RemoteController(device);
        basicOptions();
        System.out.println("5 - Sair");
        int option = 0;

        while ((option = ConsoleUtils.readInt()) != 5) {
            switch (option) {
                case 1 -> controller.powerOn();
                case 2 -> controller.powerOff();
                case 3 -> controller.increaseVolume(1);
                case 4 -> controller.decreaseVolume(1);
                default -> System.out.println("Invalid option");
            }
        };
        System.out.println("Saindo...");
    }
    private void advancedController() {
        var controller = new AdvancedRemoteController(device);
        basicOptions();
        advancedOptions();
        System.out.println("7 - Sair");
        int option = 0;
        while ((option = ConsoleUtils.readInt()) != 7) {
            switch (option) {
                case 1 -> controller.powerOn();
                case 2 -> controller.powerOff();
                case 3 -> controller.increaseVolume(1);
                case 4 -> controller.decreaseVolume(1);
                case 5 -> controller.mute();
                case 6 -> controller.unmute();
                default -> System.out.println("Invalid option");
            }
        }
        System.out.println("Saindo...");
    }
}
