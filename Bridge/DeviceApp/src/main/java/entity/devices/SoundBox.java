package entity.devices;

// Contém a mesma implementação, mas na pratica, seria uma lógica para cada dispositivo, por isso
// dessa duplicação de codigo!

public class SoundBox implements Device {
    private final int maxVolume = 100;
    private final int minVolume = 0;
    private int vol = 30; // max 100
    private boolean powerOn = false;


    public void powerOn() {
        // Custom logic...
        System.out.println("Command received");
        if(powerOn == true) {
            System.out.println("Device already connected");
        } else {
            this.powerOn = true;
            System.out.println("Starting radio!");
        }
    }

    public void powerOff() {
        // Custom logic...
        System.out.println("Command received");
        if(powerOn == false) {
            System.out.println("Device already offline");
        } else {
            System.out.println("Stoping radio!");
            this.powerOn = false;
        }
    }

    @Override
    public void increaseVolume() {
        if(powerOn == false) {
            System.out.println("Device off");
            return;
        }
        // Custom logic...
        System.out.println("Command received");
        if(vol == maxVolume) {
            System.out.println("Maximum volume reached");
            return;
        }
        System.out.println("Increasing volume!");
        vol++;
        System.out.println("New volume: " + vol);
    }

    @Override
    public void decreaseVolume() {
        if(powerOn == false) {
            System.out.println("Device off");
            return;
        }
        // Custom logic...
        System.out.println("Command received");
        if(vol == minVolume) {
            System.out.println("Minimum volume reached");
            return;
        }
        System.out.println("Decreasing volume!");
        vol--;
        System.out.println("Current volume: " + vol);
    }

    @Override
    public int getVolume() {
        if(powerOn == false) {
            System.out.println("Device off");
            return 0;
        }
        // Custom logic...
        return vol;
    }
}
