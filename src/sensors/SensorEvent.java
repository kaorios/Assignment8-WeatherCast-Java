package sensors;

public abstract class SensorEvent {

    private final Object source;
    private int value;

    SensorEvent(Object source, int value) {
        this.source = source;
        this.value = value;
    }

    public Object getSource() {
        return source;
    }

    public int getValue() {
        return value;
    }
}
