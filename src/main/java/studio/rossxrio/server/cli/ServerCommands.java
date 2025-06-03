package studio.rossxrio.server.cli;

import studio.rossxrio.server.core.GRPCServer;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ServerCommands {
    private final Command COMMAND;

    public ServerCommands(Command command) {
        COMMAND = command;
    }

    public void runCommand() throws InterruptedException{
        switch (COMMAND.getCommand()) {
            case "ping" :
                pong();
                break;
            case "date" :
                date();
                break;
            case "time" :
                time();
                break;
            case "stop" :
                stop();
                break;
        }
    }

    private void pong() {
        System.out.println("pong");
    }

    private void date() {
        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("MM-dd")));
    }

    private void time() {
        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm")));
    }

    private void stop() throws InterruptedException {
        GRPCServer.server.shutdownNow();
        GRPCServer.serverInfo.interrupt();
        GRPCServer.serverCLI.interrupt();
        throw new InterruptedException();
    }
}
