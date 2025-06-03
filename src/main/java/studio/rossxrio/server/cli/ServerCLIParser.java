package studio.rossxrio.server.cli;

import java.util.Scanner;

public class ServerCLIParser {
    private final Scanner IN;
    private Command command;

    public ServerCLIParser() {
        IN = new Scanner(System.in);
        command = null;
    }

    public String readIn() throws CommandSyntaxException {
        String input = IN.nextLine();
        buildCommand(input);

        return input;
    }

    private void buildCommand(String input) throws CommandSyntaxException {
        if (input.isBlank()) throw new CommandSyntaxException("Invalid command");

        String[] components = input.split(" ");
        if (components.length == 1) command = new Command(components[0], "");
        else {
            String args = "";
            for (String component : components) {
                if (!component.equals(components[0])) args += component + " ";
            }
            command = new Command(components[0], args);
        }

    }

    public Command getCommand() {
        return command;
    }
}
