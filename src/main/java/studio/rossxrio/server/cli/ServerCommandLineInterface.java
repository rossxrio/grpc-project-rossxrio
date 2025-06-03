package studio.rossxrio.server.cli;

import studio.rossxrio.server.core.GRPCServer;

public class ServerCommandLineInterface implements Runnable {
    private final ServerCommandLineParser SERVER_COMMAND_LINE_PARSER;

    public ServerCommandLineInterface() {
        SERVER_COMMAND_LINE_PARSER = new ServerCommandLineParser();
    }

    @Override
    public void run() {
        while (!GRPCServer.serverStop) {
            try {
                System.out.print("> ");
                String userInput = SERVER_COMMAND_LINE_PARSER.readIn();
                if (!userInput.isEmpty()) {
                    ServerCommands.commandInterface(SERVER_COMMAND_LINE_PARSER.getCommand());
                }
            } catch (Exception e) {
                System.err.print(e);
            }
        }
    }
}
