package entity.controller;

import entity.devices.Device;

public class RemoteControllerFactory {
    private RemoteControllerFactory() {}

    public static RemoteController getRemoteController(Device device) {
        return new RemoteController(device);
    }
    public static AdvancedRemoteController getAdvancedRemoteController(Device device) {
        return new AdvancedRemoteController(device);
    }
}
