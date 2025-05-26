package entity.controller;

import entity.devices.Device;

public class RemoteController {
    private final Device device;

    public RemoteController(Device device) {
        this.device = device;
    }

    public void powerOn() {
        device.powerOn();
    }
    public void powerOff() {
        device.powerOff();
    }
    public void increaseVolume(int value) {
        for (int i = 0; i < value; i++) {
            device.increaseVolume();
        }
    }
    public void decreaseVolume(int value) {
        for (int i = 0; i < value; i++) {
            device.decreaseVolume();
        }
    }
}
