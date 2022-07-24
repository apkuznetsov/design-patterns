package kuznetsov.mvc.tests;

import kuznetsov.mvc.controllers.BeatController;
import kuznetsov.mvc.interfaces.BeatModelInterface;
import kuznetsov.mvc.interfaces.ControllerInterface;
import kuznetsov.mvc.models.BeatModel;

public class DjTestDrive {

    public static void main(String[] args) {
        BeatModelInterface model = new BeatModel();
        ControllerInterface controller = new BeatController(model);
    }
}
