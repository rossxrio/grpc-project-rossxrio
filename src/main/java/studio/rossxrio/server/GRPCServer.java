package studio.rossxrio.server;

import io.grpc.ServerBuilder;
import io.grpc.Server;
import studio.rossxrio.server.utility.ServerMessageLevel;

import java.io.IOException;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * This class launch the server and hold static variables
 * needed for thread management
 */
public class GRPCServer {
    protected final static Lock LOCK = new ReentrantLock();
    protected final static Condition DATA_BUFFER_CON = LOCK.newCondition();
    protected final static Condition WRITE_CON = LOCK.newCondition();
    protected final static Condition INFO_C0N = LOCK.newCondition();
    protected static int turn = 1;

    public static void main(String[] args) {
        Server server = ServerBuilder.forPort(3009).addService(new ServerClientAPI()).build();
        Thread serverInfo = new Thread(new ServerInformation());
        try {
            server.start();
            serverInfo.start();
            ServerInformation.newMessage(String.format("Server started at %d. Services available %d\n", server.getPort(), server.getServices().size()), ServerMessageLevel.INFO);

            server.awaitTermination();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
