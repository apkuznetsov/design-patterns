package kuznetsov.mvc.controllers;

import kuznetsov.mvc.interfaces.BeatModelInterface;
import kuznetsov.mvc.interfaces.ControllerInterface;
import kuznetsov.mvc.views.DjView;

public class BeatController implements ControllerInterface {
    BeatModelInterface model;
    DjView view;

    public BeatController(BeatModelInterface model) {
        this.model = model;
        view = new DjView(this, model);
        view.createView();
        view.createControls();
        view.disableStopMenuItem();
        view.enableStartMenuItem();
        model.initialize();
    }

    public void start() {
        model.on();
        view.disableStartMenuItem();
        view.enableStopMenuItem();
    }

    public void stop() {
        model.off();
        view.disableStopMenuItem();
        view.enableStartMenuItem();
    }

    public void increaseBPM() {
        int bpm = model.getBPM();
        model.setBpm(bpm + 1);
    }

    public void decreaseBPM() {
        int bpm = model.getBPM();
        model.setBpm(bpm - 1);
    }

    public void setBpm(int bpm) {
        model.setBpm(bpm);
    }
}
