package studio.rossxrio.server.cli.utility;

public class Command {
    private final String COMMAND;
    private final String ARGS;

    public Command(String command, String args) {
        COMMAND = command;
        ARGS = args;
    }

    public String getCommand() {
        return COMMAND;
    }

    public String getArgs() {
        return ARGS;
    }
}
