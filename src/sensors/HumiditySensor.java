package sensors;

import java.util.Observable;

public class HumiditySensor extends Observable {
    private int humidity;

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
        this.setChanged(); // こいつが変更されたこと自体をObserverに知らせる => これをしないと無視していい変更だと思われるよ
        notifyObservers(new HumiditySensorEvent(this, humidity)); // 変更された内容をObserverに知らせる
    }
}

class HumiditySensorEvent extends SensorEvent {

    HumiditySensorEvent(Object source, int value) {
        super(source, value);
    }
}
