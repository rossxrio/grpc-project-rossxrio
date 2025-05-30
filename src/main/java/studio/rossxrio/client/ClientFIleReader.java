package studio.rossxrio.client;

import java.io.*;

public class ClientFIleReader implements Runnable {
    private final BufferedReader BUFFERED_READER;
    public static boolean endReading = false;

    /**
     * Initialize a ClientFileReader object
     * @param fileName the actual path of the file to be read
     */
    public ClientFIleReader(String fileName) {
        try {
            FileReader fileReader = new FileReader(fileName);
            BUFFERED_READER = new BufferedReader(fileReader);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);

        }
    }

    /**
     * Read the file on the given path line by line
     * and write word per word on the shared resource
     */
    private void readFile() {
        try {
            String line;
            while ((line = BUFFERED_READER.readLine()) != null) {
                GRPCClient.LOCK.lock();
                while (GRPCClient.turn != 1) GRPCClient.READ_CON.await();
                ClientInformation.readLines++;

                String[] words = line.split(" ");
                for (String word : words) ClientDataBank.writeData(word);

                System.out.printf("Writing line: %s\n", line);

                GRPCClient.turn = 2;
                GRPCClient.STREAM_CON.signal();
                GRPCClient.LOCK.unlock();
            }
        } catch (IOException | InterruptedException e) {
            System.out.printf("Something went wrong at reading (%s)\n", e);
        } finally {
            ClientInformation.servicesAlive--;
            endReading = true;

            ClientDataBank.writeData(" -1");
            System.out.println("Closing reader...");
        }
    }

    @Override
    public void run() {
        readFile();
    }
}