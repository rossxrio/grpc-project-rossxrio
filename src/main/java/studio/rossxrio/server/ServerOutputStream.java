package studio.rossxrio.server;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ServerOutputStream {
    private FileWriter fileWriter;

    public ServerOutputStream() {
        String path = String.format("logs/%s", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm")));
        File log = new File(path);

        try {
            if (!log.exists()) {
                if (log.createNewFile()) {
                    fileWriter = new FileWriter(path, true);
                }
            } fileWriter = new FileWriter(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public void out(String serverMessage) {
        try {
            fileWriter.append(serverMessage);
            fileWriter.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.print(serverMessage);
    }
}