package database;

import java.util.ArrayList;
import java.util.Iterator;

public class Database<DataPoint> implements Iterable<DataPoint> {

    private ArrayList<DataPoint> dataPoints = new ArrayList<DataPoint>();

    public void push(DataPoint dataPoint) {
        this.dataPoints.add(dataPoint);
    }

    int getDataPointsCount() {
        return dataPoints.size();
    }

    DataPoint getDataPointAt(int index) {
        return dataPoints.get(index);
    }

    @Override
    public Iterator<DataPoint> iterator() {
        return new DatabaseIterator(this);
    }
}
