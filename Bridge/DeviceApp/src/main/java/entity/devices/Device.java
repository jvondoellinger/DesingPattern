package entity.devices;

public interface Device {
    void powerOn();
    void powerOff();
    void increaseVolume();
    void decreaseVolume();

    int getVolume();
}
