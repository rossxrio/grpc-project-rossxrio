package studio.rossxrio.server.cli;

import studio.rossxrio.server.core.ServerInformation;
import studio.rossxrio.server.utility.ServerMessageLevel;

public class ServerCLI implements Runnable{
    private final ServerCLIParser parser;
    private ServerCommands commands;

    public ServerCLI() {
        parser = new ServerCLIParser();
        commands = null;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.print("> ");
                String input = parser.readIn();
                if (!input.isEmpty()) {
                    commands = new ServerCommands(parser.getCommand());
                    commands.runCommand();
                }
            } catch (CommandSyntaxException e) {
                ServerInformation.newMessage(e + "\n", ServerMessageLevel.WARNING);
            } catch (InterruptedException f) {
                ServerInformation.newMessage("Closing server threads (2/2)\n", ServerMessageLevel.WARNING);
                return;
            }
        }
    }
}
