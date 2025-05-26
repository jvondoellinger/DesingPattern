package entity.devices;

public class Radio implements Device {
    private final int maxVolume = 100;
    private final int minVolume = 0;
    private int vol = 30; // max 100
    private boolean powerOn = false;
    
    public void powerOn() {
        System.out.println("Command received");
        if(powerOn == true) {
            System.out.println("Device already connected");
        } else {
            this.powerOn = true;
            System.out.println("Starting radio!");
        }
    }
    
    public void powerOff() {
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
        System.out.println("Command received");
        if(vol == minVolume) {
            System.out.println("Minimum volume reached");
            return;
        }
        System.out.println("Decreasing volume!");
        vol--;
        System.out.println("New volume: " + vol);
    }

    @Override
    public int getVolume() {
        if(powerOn == false) {
            System.out.println("Device off");
            return 0;
        }
        return vol;
    }
}
