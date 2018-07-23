import database.DataCategory;
import database.DataPoint;
import database.Database;
import sensors.HumiditySensor;
import sensors.PressureSensor;
import sensors.TemperatureSensor;
import stations.NewsStation;
import stations.WeatherStation;

import java.util.Iterator;

public class ApplicationDriver {

    public static void main(String[] args) {
        HumiditySensor humiditySensor = new HumiditySensor();
        PressureSensor pressureSensor = new PressureSensor();
        TemperatureSensor temperatureSensor = new TemperatureSensor();

        WeatherStation weatherStation = new WeatherStation();
        humiditySensor.addObserver(weatherStation);
        pressureSensor.addObserver(weatherStation);
        temperatureSensor.addObserver(weatherStation);

        NewsStation newsStation = new NewsStation();
        weatherStation.addObserver(newsStation);

        Database<DataPoint> database = new Database<DataPoint>();
        database.push(new DataPoint(DataCategory.TEMPERATURE, 11));
        database.push(new DataPoint(DataCategory.TEMPERATURE, 12));
        database.push(new DataPoint(DataCategory.TEMPERATURE, 13));
        database.push(new DataPoint(DataCategory.HUMIDITY, 14));
        database.push(new DataPoint(DataCategory.HUMIDITY, 15));
        database.push(new DataPoint(DataCategory.HUMIDITY, 16));
        database.push(new DataPoint(DataCategory.PRESSURE, 17));
        database.push(new DataPoint(DataCategory.PRESSURE, 18));
        database.push(new DataPoint(DataCategory.PRESSURE, 19));
        database.push(new DataPoint(DataCategory.PRESSURE, 20));

        Iterator<DataPoint> iterator = database.iterator();
        while (iterator.hasNext()) {
            DataPoint dataPoint = iterator.next();
            switch (dataPoint.getDataCategory()) {
                case TEMPERATURE:
                    temperatureSensor.setTemperature(dataPoint.getNewValue());
                    break;
                case HUMIDITY:
                    humiditySensor.setHumidity(dataPoint.getNewValue());
                    break;
                case PRESSURE:
                    pressureSensor.setPressure(dataPoint.getNewValue());
                    break;
                default:
                    System.out.println("Some error occurred.");
            }
        }
    }
}
