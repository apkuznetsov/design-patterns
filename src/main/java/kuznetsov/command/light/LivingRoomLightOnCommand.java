package kuznetsov.command.light;

import kuznetsov.command.Command;

public class LivingRoomLightOnCommand implements Command {
    Light light;

    public LivingRoomLightOnCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.on();
    }
}
