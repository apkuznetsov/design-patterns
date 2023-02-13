package kuznetsov.mvc.controllers;

import kuznetsov.mvc.interfaces.ControllerInterface;
import kuznetsov.mvc.interfaces.HeartModelInterface;
import kuznetsov.mvc.models.HeartAdapter;
import kuznetsov.mvc.views.DjView;

public class HeartController implements ControllerInterface {
    HeartModelInterface model;
    DjView view;

    public HeartController(HeartModelInterface model) {
        this.model = model;
        view = new DjView(this, new HeartAdapter(model));
        view.createView();
        view.createControls();
        view.disableStopMenuItem();
        view.disableStartMenuItem();
    }

    public void start() {
    }

    public void stop() {
    }

    public void increaseBPM() {
    }

    public void decreaseBPM() {
    }

    public void setBpm(int bpm) {
    }
}



