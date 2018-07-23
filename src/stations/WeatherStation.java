package stations;

import sensors.HumiditySensor;
import sensors.PressureSensor;
import sensors.SensorEvent;
import sensors.TemperatureSensor;

import java.util.Observable;
import java.util.Observer;

public class WeatherStation extends Observable implements Observer {

    private Double averageTemperature = 0.0;
    private Double averageHumidity = 0.0;
    private Double averagePressure = 0.0;

    @Override
    public void update(Observable o, Object arg) { // notifyと一緒
        if (!(arg instanceof SensorEvent)) return;

        SensorEvent event = (SensorEvent) arg;
        if (event.getSource() instanceof TemperatureSensor) {
            averageTemperature = (averageTemperature + event.getValue()) / 2;
        } else if (event.getSource() instanceof HumiditySensor) {
            averageHumidity = (averageHumidity + event.getValue()) / 2;
        } else if (event.getSource() instanceof PressureSensor) {
            averagePressure = (averagePressure + event.getValue()) / 2;
        }

        this.setChanged();
        String message = "averageTemperature: " + averageTemperature +
                "\naverageHumidity: " + averageHumidity +
                "\naveragePressure: " + averagePressure;
        notifyObservers(new Report(message));
    }
}
