package studio.rossxrio.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: ClientAPI.proto")
public final class UserGrpc {

  private UserGrpc() {}

  public static final String SERVICE_NAME = "User";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<studio.rossxrio.grpc.ClientAPI.Data,
      studio.rossxrio.grpc.ClientAPI.APIResponse> getStreamDataMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StreamData",
      requestType = studio.rossxrio.grpc.ClientAPI.Data.class,
      responseType = studio.rossxrio.grpc.ClientAPI.APIResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<studio.rossxrio.grpc.ClientAPI.Data,
      studio.rossxrio.grpc.ClientAPI.APIResponse> getStreamDataMethod() {
    io.grpc.MethodDescriptor<studio.rossxrio.grpc.ClientAPI.Data, studio.rossxrio.grpc.ClientAPI.APIResponse> getStreamDataMethod;
    if ((getStreamDataMethod = UserGrpc.getStreamDataMethod) == null) {
      synchronized (UserGrpc.class) {
        if ((getStreamDataMethod = UserGrpc.getStreamDataMethod) == null) {
          UserGrpc.getStreamDataMethod = getStreamDataMethod = 
              io.grpc.MethodDescriptor.<studio.rossxrio.grpc.ClientAPI.Data, studio.rossxrio.grpc.ClientAPI.APIResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "User", "StreamData"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  studio.rossxrio.grpc.ClientAPI.Data.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  studio.rossxrio.grpc.ClientAPI.APIResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new UserMethodDescriptorSupplier("StreamData"))
                  .build();
          }
        }
     }
     return getStreamDataMethod;
  }

  private static volatile io.grpc.MethodDescriptor<studio.rossxrio.grpc.ClientAPI.LoginRequest,
      studio.rossxrio.grpc.ClientAPI.APIResponse> getLoginMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Login",
      requestType = studio.rossxrio.grpc.ClientAPI.LoginRequest.class,
      responseType = studio.rossxrio.grpc.ClientAPI.APIResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<studio.rossxrio.grpc.ClientAPI.LoginRequest,
      studio.rossxrio.grpc.ClientAPI.APIResponse> getLoginMethod() {
    io.grpc.MethodDescriptor<studio.rossxrio.grpc.ClientAPI.LoginRequest, studio.rossxrio.grpc.ClientAPI.APIResponse> getLoginMethod;
    if ((getLoginMethod = UserGrpc.getLoginMethod) == null) {
      synchronized (UserGrpc.class) {
        if ((getLoginMethod = UserGrpc.getLoginMethod) == null) {
          UserGrpc.getLoginMethod = getLoginMethod = 
              io.grpc.MethodDescriptor.<studio.rossxrio.grpc.ClientAPI.LoginRequest, studio.rossxrio.grpc.ClientAPI.APIResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "User", "Login"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  studio.rossxrio.grpc.ClientAPI.LoginRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  studio.rossxrio.grpc.ClientAPI.APIResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new UserMethodDescriptorSupplier("Login"))
                  .build();
          }
        }
     }
     return getLoginMethod;
  }

  private static volatile io.grpc.MethodDescriptor<studio.rossxrio.grpc.ClientAPI.LogoutRequest,
      studio.rossxrio.grpc.ClientAPI.APIResponse> getLogoutMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Logout",
      requestType = studio.rossxrio.grpc.ClientAPI.LogoutRequest.class,
      responseType = studio.rossxrio.grpc.ClientAPI.APIResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<studio.rossxrio.grpc.ClientAPI.LogoutRequest,
      studio.rossxrio.grpc.ClientAPI.APIResponse> getLogoutMethod() {
    io.grpc.MethodDescriptor<studio.rossxrio.grpc.ClientAPI.LogoutRequest, studio.rossxrio.grpc.ClientAPI.APIResponse> getLogoutMethod;
    if ((getLogoutMethod = UserGrpc.getLogoutMethod) == null) {
      synchronized (UserGrpc.class) {
        if ((getLogoutMethod = UserGrpc.getLogoutMethod) == null) {
          UserGrpc.getLogoutMethod = getLogoutMethod = 
              io.grpc.MethodDescriptor.<studio.rossxrio.grpc.ClientAPI.LogoutRequest, studio.rossxrio.grpc.ClientAPI.APIResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "User", "Logout"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  studio.rossxrio.grpc.ClientAPI.LogoutRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  studio.rossxrio.grpc.ClientAPI.APIResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new UserMethodDescriptorSupplier("Logout"))
                  .build();
          }
        }
     }
     return getLogoutMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static UserStub newStub(io.grpc.Channel channel) {
    return new UserStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static UserBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new UserBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static UserFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new UserFutureStub(channel);
  }

  /**
   */
  public static abstract class UserImplBase implements io.grpc.BindableService {

    /**
     */
    public void streamData(studio.rossxrio.grpc.ClientAPI.Data request,
        io.grpc.stub.StreamObserver<studio.rossxrio.grpc.ClientAPI.APIResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getStreamDataMethod(), responseObserver);
    }

    /**
     */
    public void login(studio.rossxrio.grpc.ClientAPI.LoginRequest request,
        io.grpc.stub.StreamObserver<studio.rossxrio.grpc.ClientAPI.APIResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getLoginMethod(), responseObserver);
    }

    /**
     */
    public void logout(studio.rossxrio.grpc.ClientAPI.LogoutRequest request,
        io.grpc.stub.StreamObserver<studio.rossxrio.grpc.ClientAPI.APIResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getLogoutMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getStreamDataMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                studio.rossxrio.grpc.ClientAPI.Data,
                studio.rossxrio.grpc.ClientAPI.APIResponse>(
                  this, METHODID_STREAM_DATA)))
          .addMethod(
            getLoginMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                studio.rossxrio.grpc.ClientAPI.LoginRequest,
                studio.rossxrio.grpc.ClientAPI.APIResponse>(
                  this, METHODID_LOGIN)))
          .addMethod(
            getLogoutMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                studio.rossxrio.grpc.ClientAPI.LogoutRequest,
                studio.rossxrio.grpc.ClientAPI.APIResponse>(
                  this, METHODID_LOGOUT)))
          .build();
    }
  }

  /**
   */
  public static final class UserStub extends io.grpc.stub.AbstractStub<UserStub> {
    private UserStub(io.grpc.Channel channel) {
      super(channel);
    }

    private UserStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new UserStub(channel, callOptions);
    }

    /**
     */
    public void streamData(studio.rossxrio.grpc.ClientAPI.Data request,
        io.grpc.stub.StreamObserver<studio.rossxrio.grpc.ClientAPI.APIResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getStreamDataMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void login(studio.rossxrio.grpc.ClientAPI.LoginRequest request,
        io.grpc.stub.StreamObserver<studio.rossxrio.grpc.ClientAPI.APIResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getLoginMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void logout(studio.rossxrio.grpc.ClientAPI.LogoutRequest request,
        io.grpc.stub.StreamObserver<studio.rossxrio.grpc.ClientAPI.APIResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getLogoutMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class UserBlockingStub extends io.grpc.stub.AbstractStub<UserBlockingStub> {
    private UserBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private UserBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new UserBlockingStub(channel, callOptions);
    }

    /**
     */
    public studio.rossxrio.grpc.ClientAPI.APIResponse streamData(studio.rossxrio.grpc.ClientAPI.Data request) {
      return blockingUnaryCall(
          getChannel(), getStreamDataMethod(), getCallOptions(), request);
    }

    /**
     */
    public studio.rossxrio.grpc.ClientAPI.APIResponse login(studio.rossxrio.grpc.ClientAPI.LoginRequest request) {
      return blockingUnaryCall(
          getChannel(), getLoginMethod(), getCallOptions(), request);
    }

    /**
     */
    public studio.rossxrio.grpc.ClientAPI.APIResponse logout(studio.rossxrio.grpc.ClientAPI.LogoutRequest request) {
      return blockingUnaryCall(
          getChannel(), getLogoutMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class UserFutureStub extends io.grpc.stub.AbstractStub<UserFutureStub> {
    private UserFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private UserFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new UserFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<studio.rossxrio.grpc.ClientAPI.APIResponse> streamData(
        studio.rossxrio.grpc.ClientAPI.Data request) {
      return futureUnaryCall(
          getChannel().newCall(getStreamDataMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<studio.rossxrio.grpc.ClientAPI.APIResponse> login(
        studio.rossxrio.grpc.ClientAPI.LoginRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getLoginMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<studio.rossxrio.grpc.ClientAPI.APIResponse> logout(
        studio.rossxrio.grpc.ClientAPI.LogoutRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getLogoutMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_STREAM_DATA = 0;
  private static final int METHODID_LOGIN = 1;
  private static final int METHODID_LOGOUT = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final UserImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(UserImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_STREAM_DATA:
          serviceImpl.streamData((studio.rossxrio.grpc.ClientAPI.Data) request,
              (io.grpc.stub.StreamObserver<studio.rossxrio.grpc.ClientAPI.APIResponse>) responseObserver);
          break;
        case METHODID_LOGIN:
          serviceImpl.login((studio.rossxrio.grpc.ClientAPI.LoginRequest) request,
              (io.grpc.stub.StreamObserver<studio.rossxrio.grpc.ClientAPI.APIResponse>) responseObserver);
          break;
        case METHODID_LOGOUT:
          serviceImpl.logout((studio.rossxrio.grpc.ClientAPI.LogoutRequest) request,
              (io.grpc.stub.StreamObserver<studio.rossxrio.grpc.ClientAPI.APIResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class UserBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    UserBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return studio.rossxrio.grpc.ClientAPI.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("User");
    }
  }

  private static final class UserFileDescriptorSupplier
      extends UserBaseDescriptorSupplier {
    UserFileDescriptorSupplier() {}
  }

  private static final class UserMethodDescriptorSupplier
      extends UserBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    UserMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (UserGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new UserFileDescriptorSupplier())
              .addMethod(getStreamDataMethod())
              .addMethod(getLoginMethod())
              .addMethod(getLogoutMethod())
              .build();
        }
      }
    }
    return result;
  }
}
