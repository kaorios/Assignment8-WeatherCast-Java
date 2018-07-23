package database;

import java.util.Iterator;

public class DatabaseIterator<DataPoint> implements Iterator<DataPoint> {
    private Database<DataPoint> database;
    private int index;

    DatabaseIterator(Database<DataPoint> database) {
        this.database = database;
        index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < database.getDataPointsCount();
    }

    @Override
    public DataPoint next() {
        DataPoint dataPoint = database.getDataPointAt(index);
        index++;
        return dataPoint;
    }

    @Override
    public void remove() {

    }
}
