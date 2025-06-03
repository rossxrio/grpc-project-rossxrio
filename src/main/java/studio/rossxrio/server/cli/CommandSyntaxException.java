package studio.rossxrio.server.cli;

public class CommandSyntaxException extends RuntimeException{
    private final String MESSAGE;

    public CommandSyntaxException(String message) {
        MESSAGE = message;
    }

    @Override
    public String toString() {
        return MESSAGE;
    }
}
