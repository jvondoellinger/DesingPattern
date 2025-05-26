package console;

import entity.devices.Device;

public class ControllerFactory {
    private ControllerFactory() {}

    public static ControllerConsole getInstance(Device device) {
        return new ControllerConsole(device);
    }
}
