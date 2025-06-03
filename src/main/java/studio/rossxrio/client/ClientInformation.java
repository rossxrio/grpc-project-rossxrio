package studio.rossxrio.client;

import java.util.List;

/**
 * This class serves as periodic report of the actions on the client
 */
public class ClientInformation implements Runnable {
    public static int readLines = 0;
    public static int sentWords = 0;
    public static int servicesAlive = 2;

    /**
     * Print any relevant information
     */
    private void clientInformation() {
        try {
            while (!ClientFIleReader.endReading || !ClientDataStream.endStreaming) {
                GRPCClient.LOCK.lock();
                while (GRPCClient.turn != 3) GRPCClient.INFO_C0N.await();

                List<String> dataCollect = ClientDataBank.getDataBank();
                System.out.printf("Lines read: %d, words on memory: %d, words sent: %d\n", readLines, dataCollect.size(), sentWords);

                // ClientFileReader ends a lot faster than ClientDataStream so this ensures the loop doesn't serverStop
                if (ClientFIleReader.endReading) {
                    GRPCClient.turn = 2;
                    GRPCClient.STREAM_CON.signal();
                    GRPCClient.LOCK.unlock();
                } else {
                    GRPCClient.turn = 1;
                    GRPCClient.READ_CON.signal();
                    GRPCClient.LOCK.unlock();
                }

            }
        } catch (InterruptedException e) {
            System.out.printf("Something went wrong at printing information (%s)", e);
        }

        System.out.println("Closing, no services alive...");
    }

    @Override
    public void run() {
        clientInformation();
    }

}