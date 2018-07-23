package sensors;

import java.util.Observable;

public class TemperatureSensor extends Observable {
    private int temperature;

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
        this.setChanged(); // こいつが変更されたこと自体をObserverに知らせる => これをしないと無視していい変更だと思われるよ
        notifyObservers(new TemperatureSensorEvent(this, temperature)); // 変更された内容をObserverに知らせる
    }
}

class TemperatureSensorEvent extends SensorEvent {

    TemperatureSensorEvent(Object source, int value) {
        super(source, value);
    }
}

