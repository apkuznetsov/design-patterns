package kuznetsov.command.light;

import kuznetsov.command.Command;

public class LivingRoomLightOffCommand implements Command {
    Light light;

    public LivingRoomLightOffCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.off();
    }
}
