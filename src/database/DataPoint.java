package database;

public class DataPoint {
    private DataCategory dataCategory;
    private int newValue;

    public DataPoint(DataCategory dataCategory, int value) {
        this.dataCategory = dataCategory;
        newValue = value;
    }

    public DataCategory getDataCategory() {
        return dataCategory;
    }

    public int getNewValue() {
        return newValue;
    }
}
