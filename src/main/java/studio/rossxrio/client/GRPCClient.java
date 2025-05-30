package studio.rossxrio.client;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * This class launch the client and hold static variables
 * needed for thread management
 */
public class GRPCClient {
    protected final static Lock LOCK = new ReentrantLock();
    protected final static Condition READ_CON = LOCK.newCondition();
    protected final static Condition STREAM_CON = LOCK.newCondition();
    protected final static Condition INFO_C0N = LOCK.newCondition();
    protected static int turn = 1;
    
    public static void main(String[] args) {
        Thread readThread = new Thread(new ClientFIleReader("src/main/resources/inputFile.txt"));
        // server address pattern: address:port
        Thread dataStreamThread = new Thread(new ClientDataStream("Carlos", "Carlos", "localhost:3009"));
        Thread statsThread= new Thread(new ClientInformation());

        readThread.start();
        dataStreamThread.start();
        statsThread.start();
    }
}
