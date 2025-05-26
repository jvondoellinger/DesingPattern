package entity.controller;

import entity.devices.Device;

public class AdvancedRemoteController extends RemoteController {
    private final Device device;
    private int lastVol = 0;
    public AdvancedRemoteController(Device device) {
        super(device);
        this.device = device;
    }

    public void mute() {
        lastVol = device.getVolume();
        decreaseVolume(device.getVolume());
    }

    public void unmute() {
        increaseVolume(lastVol);
        lastVol = 0;
    }

}
