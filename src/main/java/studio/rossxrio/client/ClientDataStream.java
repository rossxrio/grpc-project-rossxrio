package studio.rossxrio.client;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import studio.rossxrio.grpc.ClientAPI;
import studio.rossxrio.grpc.UserGrpc;

/**
 * This class establish the connection with the server
 * and sent the data
 */
public class ClientDataStream implements Runnable {
    private final String USER_ALIAS;
    private final String USER_PASSWORD;
    private final UserGrpc.UserBlockingStub USER_STUB;
    private final ManagedChannel CHANNEL;
    public static boolean endStreaming = false;

    public ClientDataStream(String userAlias, String userPassword, String serverAddress) {

        USER_ALIAS = userAlias;
        USER_PASSWORD = userPassword;

        String[] SERVER_ADDRESS = serverAddress.split(":");

        CHANNEL = ManagedChannelBuilder.forAddress(SERVER_ADDRESS[0], Integer.parseInt(SERVER_ADDRESS[1])).usePlaintext().build();
        USER_STUB = UserGrpc.newBlockingStub(CHANNEL);
    }

    /**
     * Send a login request
     */
    private void clientLogin() {
        ClientAPI.LoginRequest loginRequest = ClientAPI.LoginRequest.newBuilder().setUserName(USER_ALIAS).setPassword(USER_PASSWORD).build();
        ClientAPI.APIResponse response = USER_STUB.login(loginRequest);
        System.out.println(response);
    }

    /**
     * Send a logout request
     */
    private void clientLogout() {
        ClientAPI.LogoutRequest logoutRequest = ClientAPI.LogoutRequest.newBuilder().setUserName(USER_ALIAS).build();
        ClientAPI.APIResponse response = USER_STUB.logout(logoutRequest);
        System.out.println(response);
        CHANNEL.shutdownNow();
    }

    /**
     * Ensure the data to be sent isn't null nor "-1"
     *
     * @param data String that contain the data for the request
     * @return boolean whether the data is valid or not
     */
    private boolean validateData(String data) {
        return data != null && !data.equals("-1");
    }

    /**
     * In charge of the streaming of data
     */
    private void startDataStream() {
        try {
            clientLogin();
            int i = 0;
            String data = ClientDataBank.readData(i);
            while (validateData(data)) {
                GRPCClient.LOCK.lock();
                while (GRPCClient.turn != 2) GRPCClient.STREAM_CON.await();

                ClientAPI.Data request = ClientAPI.Data.newBuilder().setAlias(USER_ALIAS).setData(data.toUpperCase()).build();
                ClientAPI.APIResponse response = USER_STUB.streamData(request);
                ClientInformation.sentWords++;
                System.out.println(response);

                data = ClientDataBank.readData(i);
                i++;

                GRPCClient.turn = 3;
                GRPCClient.INFO_C0N.signal();
                GRPCClient.LOCK.unlock();
            }
        } catch (InterruptedException e) {
            System.out.printf("Something went wrong at streaming data (%s)", e);
        } finally {
            endStreaming = true;
            System.out.println("sending end tail");
            ClientAPI.Data request = ClientAPI.Data.newBuilder().setAlias(USER_ALIAS).setData(ClientDataBank.readData(ClientDataBank.getDataBank().size() -1)).build();
            System.out.println(request);
            System.out.println("login out...");
            clientLogout();
        }
    }

    @Override
    public void run() {
        startDataStream();
    }
}