package kuznetsov.mvc.tests;

import kuznetsov.mvc.controllers.HeartController;
import kuznetsov.mvc.interfaces.ControllerInterface;
import kuznetsov.mvc.models.HeartModel;

public class HeartTestDrive {

    public static void main(String[] args) {
        HeartModel heartModel = new HeartModel();
        ControllerInterface model = new HeartController(heartModel);
    }
}
