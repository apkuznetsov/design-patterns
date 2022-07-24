package kuznetsov.mvc.interfaces;

import kuznetsov.mvc.observers.BeatObserver;
import kuznetsov.mvc.observers.BpmObserver;

public interface HeartModelInterface {
    int getHeartRate();

    void registerObserver(BeatObserver o);

    void removeObserver(BeatObserver o);

    void registerObserver(BpmObserver o);

    void removeObserver(BpmObserver o);
}
