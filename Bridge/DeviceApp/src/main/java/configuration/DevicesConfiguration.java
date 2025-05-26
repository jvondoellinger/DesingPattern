package configuration;

import entity.devices.Device;
import entity.devices.Radio;
import entity.devices.SoundBox;

public class DevicesConfiguration {
    private static final Device radio = new Radio();
    private static final Device soundBox = new SoundBox();


    public static Device getRadioInstance() {
        return radio;
    }

    public static Device getSoundBoxInstance() {
        return soundBox;
    }
}
