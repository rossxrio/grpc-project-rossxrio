package studio.rossxrio.server;

import studio.rossxrio.server.utility.ServerMessageLevel;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * This class create and write a file for each user logged in
 */
public class ServerFileWriterThread implements Runnable {
    private final File file;
    private FileWriter fileWriter;
    private final String USER_ALIAS;

    public ServerFileWriterThread(String USER_ALIAS) {
        this.USER_ALIAS = USER_ALIAS;

        String path = String.format("outputFiles/%s.txt", USER_ALIAS);
        file = new File(path);
        if (createFile()) {
            try {
                fileWriter = new FileWriter(path);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

    // Try to create a file
    private boolean createFile() {
        boolean isSuccess = true;
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException e) {
            ServerInformation.newMessage(String.format("Something went wrong while creating an user file\n %s", e), ServerMessageLevel.ERROR);
            isSuccess = false;
        }

        return isSuccess;
    }

    private void writeFile() {
        int i = 0;
        List<String> indexData = new ArrayList<>();
        while (ServerInformation.servicesAlive != 1) {
            try {
                GRPCServer.LOCK.lock();
                while (GRPCServer.turn != 2) GRPCServer.WRITE_CON.await();

                if (ServerDataBank.readData(USER_ALIAS) != null) {
                    indexData.add(ServerDataBank.readData(USER_ALIAS));

                    fileWriter.write(String.format("%s, \n", indexData.get(i)));
                    ServerInformation.wordsWriten++;
                    fileWriter.flush();

                    if (indexData.get(i).equals(" -1")) {
                        ServerInformation.newMessage(String.format("User %s issued a -1, closing writer service\n", USER_ALIAS), ServerMessageLevel.INFO);
                        ServerInformation.servicesAlive--;
                        return;
                    }

                    i++;
                }
            } catch (IOException | InterruptedException e) {
                ServerInformation.newMessage(String.format("Something went really wrong at writing...\n (%s)", e), ServerMessageLevel.ERROR);
            } finally {
                GRPCServer.turn = 3;
                GRPCServer.INFO_C0N.signal();
                GRPCServer.LOCK.unlock();
            }
        }

    }

    @Override
    public void run() {
        writeFile();
    }
}