package studio.rossxrio.server.utility;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ServerMessage {
    private final LocalDateTime timeStamp;
    private final String message;
    private final DateTimeFormatter formatter;
    private final String serverMessageLevel;

    public ServerMessage(LocalDateTime localDateTime, String message, ServerMessageLevel serverMessageLevel) {
        timeStamp = localDateTime;
        this.message = message;
        formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        this.serverMessageLevel = serverMessageLevel.toString();
    }

    @Override
    public String toString() {
        return String.format("[%s] [Server at %s]: %s", serverMessageLevel, formatter.format(timeStamp), message);
    }
}
