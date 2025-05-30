package studio.rossxrio.server;

import studio.rossxrio.server.utility.ClientData;
import studio.rossxrio.server.utility.ServerMessageLevel;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * This class queues the client's requests.
 * The de-queuing is done by a thread isolated from the main.
 * I did this because I thought it was good that the client doesn't have to wait for the information to be de-queued, not to mention waiting for the thread's turn.
 */
public class ServerDataBuffer implements Runnable {
    public static final BlockingQueue<ClientData> DATA_BUFFER = new ArrayBlockingQueue<>(50, false);

    /**
     * Add the data request to the queue
     * @param clientData ClientData is form by an alias and a data field
     */
    public static void inQueue(ClientData clientData) {
        try {
            DATA_BUFFER.put(clientData);
        } catch (InterruptedException e) {
            ServerInformation.newMessage(String.format("Something went really wrong at queueing data...\n (%s)", e), ServerMessageLevel.ERROR);
        }
    }

    /**
     * This method is triggered by each user login and run indeterminately in different thread
     */
    public static void deQueue() {
        ServerInformation.servicesAlive++;
        while (ServerInformation.servicesAlive != 1) {
            try {
                GRPCServer.LOCK.lock();
                while (GRPCServer.turn != 1) GRPCServer.DATA_BUFFER_CON.await();

                ClientData clientData = DATA_BUFFER.take();
                ServerDataBank.writeData(clientData.getAlias(), clientData.getData());

            } catch (InterruptedException e) {
                ServerInformation.newMessage(String.format("Something went really wrong at de-queueing...\n (%s)", e), ServerMessageLevel.ERROR);
            } finally {
                GRPCServer.turn = 2;
                GRPCServer.WRITE_CON.signal();
                GRPCServer.LOCK.unlock();
            }
        }
    }

    @Override
    public void run() {
        deQueue();
    }
}
