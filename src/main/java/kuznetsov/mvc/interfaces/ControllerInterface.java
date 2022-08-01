package kuznetsov.mvc.interfaces;

public interface ControllerInterface {
    void start();

    void stop();

    void increaseBPM();

    void decreaseBPM();

    void setBpm(int bpm);
}
