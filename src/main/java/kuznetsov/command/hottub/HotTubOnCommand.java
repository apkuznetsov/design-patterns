package kuznetsov.command.hottub;

import kuznetsov.command.Command;

public class HotTubOnCommand implements Command {
    HotTub hottub;

    public HotTubOnCommand(HotTub hottub) {
        this.hottub = hottub;
    }

    public void execute() {
        hottub.on();
        hottub.heat();
        hottub.bubblesOn();
    }
}
