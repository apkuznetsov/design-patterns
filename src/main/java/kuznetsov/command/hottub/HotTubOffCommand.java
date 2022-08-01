package kuznetsov.command.hottub;

import kuznetsov.command.Command;

public class HotTubOffCommand implements Command {
    HotTub hottub;

    public HotTubOffCommand(HotTub hottub) {
        this.hottub = hottub;
    }

    public void execute() {
        hottub.cool();
        hottub.off();
    }
}
