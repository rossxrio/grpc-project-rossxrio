package studio.rossxrio.server.cli;

import studio.rossxrio.server.cli.utility.Command;

import java.util.Scanner;

public class ServerCommandLineParser {
    private final Scanner IN;
    private Command command;

    public ServerCommandLineParser() {
        IN = new Scanner(System.in);
        command = null;
    }

    public String readIn() throws Exception {
        String userInput = IN.nextLine();
        if (!userInput.startsWith("/")) throw new Exception(" \"/\" prefix not found");

        userInput = userInput.replaceAll("/", "");
        if (userInput.isEmpty()) throw new Exception("Command is empty");

        buildCommand(userInput);
        return userInput;

    }

    private void buildCommand(String userInput) {
        String[] commandComponents = userInput.split(" ");

        if (commandComponents.length == 1) command = new Command(commandComponents[0], "");
        else {
            String args = "";
            for (String component : commandComponents) {
                args += component;
            }

            command = new Command(commandComponents[0], args);
        }
    }

    public Command getCommand() {
        return command;
    }
}
