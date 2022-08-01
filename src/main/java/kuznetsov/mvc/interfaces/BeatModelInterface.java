package kuznetsov.mvc.interfaces;

import kuznetsov.mvc.observers.BeatObserver;
import kuznetsov.mvc.observers.BpmObserver;

public interface BeatModelInterface {
    void initialize();

    void on();

    void off();

    int getBPM();

    void setBpm(int bpm);

    void registerObserver(BeatObserver o);

    void removeObserver(BeatObserver o);

    void registerObserver(BpmObserver o);

    void removeObserver(BpmObserver o);
}
