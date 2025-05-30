package studio.rossxrio.server.core;

import io.grpc.stub.StreamObserver;
import studio.rossxrio.grpc.ClientAPI;
import studio.rossxrio.grpc.UserGrpc;
import studio.rossxrio.server.utility.ClientData;
import studio.rossxrio.server.utility.ServerMessageLevel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * This class implement the user interface defined on the .proto file
 */
public class ServerClientAPI extends UserGrpc.UserImplBase {
    protected static final List<String> USERS_ONLINE = new ArrayList<>();
    protected static final HashMap<String, Integer> USER_LINES_COUNT = new HashMap<>();

    @Override
    public void streamData(ClientAPI.Data request, StreamObserver<ClientAPI.APIResponse> responseObserver) {
        if (!USERS_ONLINE.contains(request.getAlias())) {
            ClientAPI.APIResponse response = ClientAPI.APIResponse.newBuilder().setResponseMessage("Must be logged in").setResponseCode(400).build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
        else {
            final String[] USER_WORDS = request.getData().split(" ");
            USER_LINES_COUNT.put(request.getAlias(), USER_LINES_COUNT.getOrDefault(request.getAlias(), 0) + USER_WORDS.length);

            ClientAPI.APIResponse response = ClientAPI.APIResponse.newBuilder().setResponseMessage("data sent: " + request.getData() + "from: " + request.getAlias()).setResponseCode(200).build();

            ServerDataBuffer.inQueue(new ClientData(request.getAlias(), request.getData()));
            ServerInformation.newMessage(String.format("Catching data (%s) from %s\n", request.getData(), request.getAlias()), ServerMessageLevel.INFO);

            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }

    @Override
    public void login(ClientAPI.LoginRequest request, StreamObserver<ClientAPI.APIResponse> responseObserver) {
        ServerInformation.clientsOnline++;
        ServerInformation.newMessage(String.format("%s has logged in\n", request.getUserName()), ServerMessageLevel.USER);

        if (!USERS_ONLINE.contains(request.getUserName())) {
            Thread dataBuffer = new Thread(new ServerDataBuffer());
            ServerInformation.newMessage(String.format("Starting new data buffer service for %s...\n", request.getUserName()), ServerMessageLevel.INFO);
            dataBuffer.start();

            Thread fileWriter = new Thread(new ServerFileWriterThread(request.getUserName()));
            ServerInformation.newMessage(String.format("Starting new writer service for %s...\n", request.getUserName()), ServerMessageLevel.INFO);
            fileWriter.start();
        }

        USERS_ONLINE.add(request.getUserName());
        ClientAPI.APIResponse response = ClientAPI.APIResponse.newBuilder().setResponseMessage("Session started for " + request.getUserName()).setResponseCode(200).build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void logout(ClientAPI.LogoutRequest request, StreamObserver<ClientAPI.APIResponse> responseObserver) {
        ServerInformation.clientsOnline--;

        USERS_ONLINE.remove(request.getUserName());
        ClientAPI.APIResponse response = ClientAPI.APIResponse.newBuilder().setResponseMessage("Bye... " + request.getUserName()).setResponseCode(200).build();

        ServerInformation.newMessage(String.format("%s has logged out\n", request.getUserName()), ServerMessageLevel.USER);

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
