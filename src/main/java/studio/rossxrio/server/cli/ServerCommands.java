package studio.rossxrio.server.cli;

import studio.rossxrio.server.cli.utility.Command;
import studio.rossxrio.server.core.GRPCServer;

public class ServerCommands {

    public static void commandInterface(Command command) {
        switch (command.getCommand()) {
            case "stop" :
                stop(command);
        }
    }

    private static void time(Command command) {}

    private static void date(Command command) {}

    private static void stop(Command command) {
        if (command.getArgs().isEmpty()) {
            GRPCServer.stop();
            GRPCServer.serverStop = true;
        }
    }


}
