package stations;

import java.util.Observable;
import java.util.Observer;

public class NewsStation implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        if (!(arg instanceof Report)) return;

        Report report = (Report) arg;
        System.out.println(report.getMessage());
    }
}
