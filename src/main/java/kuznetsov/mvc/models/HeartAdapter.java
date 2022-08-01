package kuznetsov.mvc.models;

import kuznetsov.mvc.interfaces.BeatModelInterface;
import kuznetsov.mvc.interfaces.HeartModelInterface;
import kuznetsov.mvc.observers.BeatObserver;
import kuznetsov.mvc.observers.BpmObserver;

public class HeartAdapter implements BeatModelInterface {
    HeartModelInterface heart;

    public HeartAdapter(HeartModelInterface heart) {
        this.heart = heart;
    }

    public void initialize() {
    }

    public void on() {
    }

    public void off() {
    }

    public int getBPM() {
        return heart.getHeartRate();
    }

    public void setBpm(int bpm) {
    }

    public void registerObserver(BeatObserver o) {
        heart.registerObserver(o);
    }

    public void removeObserver(BeatObserver o) {
        heart.removeObserver(o);
    }

    public void registerObserver(BpmObserver o) {
        heart.registerObserver(o);
    }

    public void removeObserver(BpmObserver o) {
        heart.removeObserver(o);
    }
}
