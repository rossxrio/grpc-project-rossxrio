package studio.rossxrio.server.core;

import studio.rossxrio.server.utility.ServerMessage;
import studio.rossxrio.server.utility.ServerMessageLevel;

import java.time.LocalDateTime;
import java.util.Map;

/**
 * This class serves as periodic report of the server events
 */
public class ServerInformation implements Runnable {
    private final static ServerOutputStream SERVER_OUTPUT_STREAM = new ServerOutputStream();

    protected static int clientsOnline = 0;
    protected static int wordsWritten = 0;

    public static int servicesAlive = 2;
    private int n = 0;

    /**
     * Print any relevant information
     */
    private void serverInformation() {
        // The loop isn't meant to stop unless interrupted
        while (true) {
            try {
                GRPCServer.LOCK.lock();
                while (GRPCServer.turn != 3) GRPCServer.INFO_C0N.await();
                while (servicesAlive < 2) GRPCServer.INFO_C0N.await();

                String dataCollect = "";
                for (Map.Entry<String, String> entry : ServerDataBank.getDataBank().entrySet()) {
                    dataCollect += entry.getValue();
                }

                String[] words = dataCollect.split(" ");
                n += words.length;
                countWords();
                newMessage(String.format("Clients online %d, words on memory %d, words written %d\n", clientsOnline, n, wordsWritten),ServerMessageLevel.INFO);

            } catch (InterruptedException e) {
                ServerInformation.newMessage("Closing server threads (1/2)\n", ServerMessageLevel.WARNING);
                return;
            } finally {
                GRPCServer.turn = 1;
                GRPCServer.DATA_BUFFER_CON.signal();
                GRPCServer.LOCK.unlock();
            }
        }
    }

    /**
     * Keep track of how many words each user sent
     */
    private void countWords() {
        for (Map.Entry<String, Integer> entry : ServerClientAPI.USER_LINES_COUNT.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(new ServerMessage(LocalDateTime.now(), String.format("The user %s has sent %d words", key, value), ServerMessageLevel.INFO));
        }
    }

    /**
     * Serves as easy way of sending a "formal" server message
     * @param message String of the message to be display
     * @param serverMessageLevel String - Specify the categories of the message
     */
    public static void newMessage(String message, ServerMessageLevel serverMessageLevel) {
        SERVER_OUTPUT_STREAM.out(new ServerMessage(LocalDateTime.now(), message, serverMessageLevel).toString());
    }

    @Override
    public void run() {
        serverInformation();
    }

}