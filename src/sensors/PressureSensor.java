package sensors;

import java.util.Observable;

public class PressureSensor extends Observable {
    private int pressure;

    public int getPressure() {
        return pressure;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
        this.setChanged(); // こいつが変更されたこと自体をObserverに知らせる => これをしないと無視していい変更だと思われるよ
        notifyObservers(new PressureSensorEvent(this, pressure)); // 変更された内容をObserverに知らせる
    }
}

class PressureSensorEvent extends SensorEvent {

    PressureSensorEvent(Object source, int value) {
        super(source, value);
    }
}
