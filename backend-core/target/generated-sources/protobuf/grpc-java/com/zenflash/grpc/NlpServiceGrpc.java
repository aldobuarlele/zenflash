package com.zenflash.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.60.0)",
    comments = "Source: zenflash.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class NlpServiceGrpc {

  private NlpServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "zenflash.NlpService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.zenflash.grpc.AnalyzeRequest,
      com.zenflash.grpc.AnalyzeResponse> getAnalyzeSentenceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AnalyzeSentence",
      requestType = com.zenflash.grpc.AnalyzeRequest.class,
      responseType = com.zenflash.grpc.AnalyzeResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.zenflash.grpc.AnalyzeRequest,
      com.zenflash.grpc.AnalyzeResponse> getAnalyzeSentenceMethod() {
    io.grpc.MethodDescriptor<com.zenflash.grpc.AnalyzeRequest, com.zenflash.grpc.AnalyzeResponse> getAnalyzeSentenceMethod;
    if ((getAnalyzeSentenceMethod = NlpServiceGrpc.getAnalyzeSentenceMethod) == null) {
      synchronized (NlpServiceGrpc.class) {
        if ((getAnalyzeSentenceMethod = NlpServiceGrpc.getAnalyzeSentenceMethod) == null) {
          NlpServiceGrpc.getAnalyzeSentenceMethod = getAnalyzeSentenceMethod =
              io.grpc.MethodDescriptor.<com.zenflash.grpc.AnalyzeRequest, com.zenflash.grpc.AnalyzeResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AnalyzeSentence"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.zenflash.grpc.AnalyzeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.zenflash.grpc.AnalyzeResponse.getDefaultInstance()))
              .setSchemaDescriptor(new NlpServiceMethodDescriptorSupplier("AnalyzeSentence"))
              .build();
        }
      }
    }
    return getAnalyzeSentenceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.zenflash.grpc.ReviewRequest,
      com.zenflash.grpc.ReviewResponse> getSubmitReviewMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SubmitReview",
      requestType = com.zenflash.grpc.ReviewRequest.class,
      responseType = com.zenflash.grpc.ReviewResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.zenflash.grpc.ReviewRequest,
      com.zenflash.grpc.ReviewResponse> getSubmitReviewMethod() {
    io.grpc.MethodDescriptor<com.zenflash.grpc.ReviewRequest, com.zenflash.grpc.ReviewResponse> getSubmitReviewMethod;
    if ((getSubmitReviewMethod = NlpServiceGrpc.getSubmitReviewMethod) == null) {
      synchronized (NlpServiceGrpc.class) {
        if ((getSubmitReviewMethod = NlpServiceGrpc.getSubmitReviewMethod) == null) {
          NlpServiceGrpc.getSubmitReviewMethod = getSubmitReviewMethod =
              io.grpc.MethodDescriptor.<com.zenflash.grpc.ReviewRequest, com.zenflash.grpc.ReviewResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SubmitReview"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.zenflash.grpc.ReviewRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.zenflash.grpc.ReviewResponse.getDefaultInstance()))
              .setSchemaDescriptor(new NlpServiceMethodDescriptorSupplier("SubmitReview"))
              .build();
        }
      }
    }
    return getSubmitReviewMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.zenflash.grpc.UpdateTranslationRequest,
      com.zenflash.grpc.UpdateTranslationResponse> getUpdateTranslationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateTranslation",
      requestType = com.zenflash.grpc.UpdateTranslationRequest.class,
      responseType = com.zenflash.grpc.UpdateTranslationResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.zenflash.grpc.UpdateTranslationRequest,
      com.zenflash.grpc.UpdateTranslationResponse> getUpdateTranslationMethod() {
    io.grpc.MethodDescriptor<com.zenflash.grpc.UpdateTranslationRequest, com.zenflash.grpc.UpdateTranslationResponse> getUpdateTranslationMethod;
    if ((getUpdateTranslationMethod = NlpServiceGrpc.getUpdateTranslationMethod) == null) {
      synchronized (NlpServiceGrpc.class) {
        if ((getUpdateTranslationMethod = NlpServiceGrpc.getUpdateTranslationMethod) == null) {
          NlpServiceGrpc.getUpdateTranslationMethod = getUpdateTranslationMethod =
              io.grpc.MethodDescriptor.<com.zenflash.grpc.UpdateTranslationRequest, com.zenflash.grpc.UpdateTranslationResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateTranslation"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.zenflash.grpc.UpdateTranslationRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.zenflash.grpc.UpdateTranslationResponse.getDefaultInstance()))
              .setSchemaDescriptor(new NlpServiceMethodDescriptorSupplier("UpdateTranslation"))
              .build();
        }
      }
    }
    return getUpdateTranslationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.zenflash.grpc.GetDueCardsRequest,
      com.zenflash.grpc.GetDueCardsResponse> getGetDueCardsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetDueCards",
      requestType = com.zenflash.grpc.GetDueCardsRequest.class,
      responseType = com.zenflash.grpc.GetDueCardsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.zenflash.grpc.GetDueCardsRequest,
      com.zenflash.grpc.GetDueCardsResponse> getGetDueCardsMethod() {
    io.grpc.MethodDescriptor<com.zenflash.grpc.GetDueCardsRequest, com.zenflash.grpc.GetDueCardsResponse> getGetDueCardsMethod;
    if ((getGetDueCardsMethod = NlpServiceGrpc.getGetDueCardsMethod) == null) {
      synchronized (NlpServiceGrpc.class) {
        if ((getGetDueCardsMethod = NlpServiceGrpc.getGetDueCardsMethod) == null) {
          NlpServiceGrpc.getGetDueCardsMethod = getGetDueCardsMethod =
              io.grpc.MethodDescriptor.<com.zenflash.grpc.GetDueCardsRequest, com.zenflash.grpc.GetDueCardsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetDueCards"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.zenflash.grpc.GetDueCardsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.zenflash.grpc.GetDueCardsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new NlpServiceMethodDescriptorSupplier("GetDueCards"))
              .build();
        }
      }
    }
    return getGetDueCardsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.zenflash.grpc.GetPendingCardsRequest,
      com.zenflash.grpc.GetPendingCardsResponse> getGetPendingCardsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetPendingCards",
      requestType = com.zenflash.grpc.GetPendingCardsRequest.class,
      responseType = com.zenflash.grpc.GetPendingCardsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.zenflash.grpc.GetPendingCardsRequest,
      com.zenflash.grpc.GetPendingCardsResponse> getGetPendingCardsMethod() {
    io.grpc.MethodDescriptor<com.zenflash.grpc.GetPendingCardsRequest, com.zenflash.grpc.GetPendingCardsResponse> getGetPendingCardsMethod;
    if ((getGetPendingCardsMethod = NlpServiceGrpc.getGetPendingCardsMethod) == null) {
      synchronized (NlpServiceGrpc.class) {
        if ((getGetPendingCardsMethod = NlpServiceGrpc.getGetPendingCardsMethod) == null) {
          NlpServiceGrpc.getGetPendingCardsMethod = getGetPendingCardsMethod =
              io.grpc.MethodDescriptor.<com.zenflash.grpc.GetPendingCardsRequest, com.zenflash.grpc.GetPendingCardsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetPendingCards"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.zenflash.grpc.GetPendingCardsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.zenflash.grpc.GetPendingCardsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new NlpServiceMethodDescriptorSupplier("GetPendingCards"))
              .build();
        }
      }
    }
    return getGetPendingCardsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static NlpServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<NlpServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<NlpServiceStub>() {
        @java.lang.Override
        public NlpServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new NlpServiceStub(channel, callOptions);
        }
      };
    return NlpServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static NlpServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<NlpServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<NlpServiceBlockingStub>() {
        @java.lang.Override
        public NlpServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new NlpServiceBlockingStub(channel, callOptions);
        }
      };
    return NlpServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static NlpServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<NlpServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<NlpServiceFutureStub>() {
        @java.lang.Override
        public NlpServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new NlpServiceFutureStub(channel, callOptions);
        }
      };
    return NlpServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void analyzeSentence(com.zenflash.grpc.AnalyzeRequest request,
        io.grpc.stub.StreamObserver<com.zenflash.grpc.AnalyzeResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAnalyzeSentenceMethod(), responseObserver);
    }

    /**
     */
    default void submitReview(com.zenflash.grpc.ReviewRequest request,
        io.grpc.stub.StreamObserver<com.zenflash.grpc.ReviewResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSubmitReviewMethod(), responseObserver);
    }

    /**
     */
    default void updateTranslation(com.zenflash.grpc.UpdateTranslationRequest request,
        io.grpc.stub.StreamObserver<com.zenflash.grpc.UpdateTranslationResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateTranslationMethod(), responseObserver);
    }

    /**
     */
    default void getDueCards(com.zenflash.grpc.GetDueCardsRequest request,
        io.grpc.stub.StreamObserver<com.zenflash.grpc.GetDueCardsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetDueCardsMethod(), responseObserver);
    }

    /**
     */
    default void getPendingCards(com.zenflash.grpc.GetPendingCardsRequest request,
        io.grpc.stub.StreamObserver<com.zenflash.grpc.GetPendingCardsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetPendingCardsMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service NlpService.
   */
  public static abstract class NlpServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return NlpServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service NlpService.
   */
  public static final class NlpServiceStub
      extends io.grpc.stub.AbstractAsyncStub<NlpServiceStub> {
    private NlpServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected NlpServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new NlpServiceStub(channel, callOptions);
    }

    /**
     */
    public void analyzeSentence(com.zenflash.grpc.AnalyzeRequest request,
        io.grpc.stub.StreamObserver<com.zenflash.grpc.AnalyzeResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAnalyzeSentenceMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void submitReview(com.zenflash.grpc.ReviewRequest request,
        io.grpc.stub.StreamObserver<com.zenflash.grpc.ReviewResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSubmitReviewMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateTranslation(com.zenflash.grpc.UpdateTranslationRequest request,
        io.grpc.stub.StreamObserver<com.zenflash.grpc.UpdateTranslationResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateTranslationMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getDueCards(com.zenflash.grpc.GetDueCardsRequest request,
        io.grpc.stub.StreamObserver<com.zenflash.grpc.GetDueCardsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetDueCardsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getPendingCards(com.zenflash.grpc.GetPendingCardsRequest request,
        io.grpc.stub.StreamObserver<com.zenflash.grpc.GetPendingCardsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetPendingCardsMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service NlpService.
   */
  public static final class NlpServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<NlpServiceBlockingStub> {
    private NlpServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected NlpServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new NlpServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.zenflash.grpc.AnalyzeResponse analyzeSentence(com.zenflash.grpc.AnalyzeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAnalyzeSentenceMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.zenflash.grpc.ReviewResponse submitReview(com.zenflash.grpc.ReviewRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSubmitReviewMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.zenflash.grpc.UpdateTranslationResponse updateTranslation(com.zenflash.grpc.UpdateTranslationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateTranslationMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.zenflash.grpc.GetDueCardsResponse getDueCards(com.zenflash.grpc.GetDueCardsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetDueCardsMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.zenflash.grpc.GetPendingCardsResponse getPendingCards(com.zenflash.grpc.GetPendingCardsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetPendingCardsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service NlpService.
   */
  public static final class NlpServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<NlpServiceFutureStub> {
    private NlpServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected NlpServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new NlpServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.zenflash.grpc.AnalyzeResponse> analyzeSentence(
        com.zenflash.grpc.AnalyzeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAnalyzeSentenceMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.zenflash.grpc.ReviewResponse> submitReview(
        com.zenflash.grpc.ReviewRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSubmitReviewMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.zenflash.grpc.UpdateTranslationResponse> updateTranslation(
        com.zenflash.grpc.UpdateTranslationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateTranslationMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.zenflash.grpc.GetDueCardsResponse> getDueCards(
        com.zenflash.grpc.GetDueCardsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetDueCardsMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.zenflash.grpc.GetPendingCardsResponse> getPendingCards(
        com.zenflash.grpc.GetPendingCardsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetPendingCardsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ANALYZE_SENTENCE = 0;
  private static final int METHODID_SUBMIT_REVIEW = 1;
  private static final int METHODID_UPDATE_TRANSLATION = 2;
  private static final int METHODID_GET_DUE_CARDS = 3;
  private static final int METHODID_GET_PENDING_CARDS = 4;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ANALYZE_SENTENCE:
          serviceImpl.analyzeSentence((com.zenflash.grpc.AnalyzeRequest) request,
              (io.grpc.stub.StreamObserver<com.zenflash.grpc.AnalyzeResponse>) responseObserver);
          break;
        case METHODID_SUBMIT_REVIEW:
          serviceImpl.submitReview((com.zenflash.grpc.ReviewRequest) request,
              (io.grpc.stub.StreamObserver<com.zenflash.grpc.ReviewResponse>) responseObserver);
          break;
        case METHODID_UPDATE_TRANSLATION:
          serviceImpl.updateTranslation((com.zenflash.grpc.UpdateTranslationRequest) request,
              (io.grpc.stub.StreamObserver<com.zenflash.grpc.UpdateTranslationResponse>) responseObserver);
          break;
        case METHODID_GET_DUE_CARDS:
          serviceImpl.getDueCards((com.zenflash.grpc.GetDueCardsRequest) request,
              (io.grpc.stub.StreamObserver<com.zenflash.grpc.GetDueCardsResponse>) responseObserver);
          break;
        case METHODID_GET_PENDING_CARDS:
          serviceImpl.getPendingCards((com.zenflash.grpc.GetPendingCardsRequest) request,
              (io.grpc.stub.StreamObserver<com.zenflash.grpc.GetPendingCardsResponse>) responseObserver);
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

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getAnalyzeSentenceMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.zenflash.grpc.AnalyzeRequest,
              com.zenflash.grpc.AnalyzeResponse>(
                service, METHODID_ANALYZE_SENTENCE)))
        .addMethod(
          getSubmitReviewMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.zenflash.grpc.ReviewRequest,
              com.zenflash.grpc.ReviewResponse>(
                service, METHODID_SUBMIT_REVIEW)))
        .addMethod(
          getUpdateTranslationMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.zenflash.grpc.UpdateTranslationRequest,
              com.zenflash.grpc.UpdateTranslationResponse>(
                service, METHODID_UPDATE_TRANSLATION)))
        .addMethod(
          getGetDueCardsMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.zenflash.grpc.GetDueCardsRequest,
              com.zenflash.grpc.GetDueCardsResponse>(
                service, METHODID_GET_DUE_CARDS)))
        .addMethod(
          getGetPendingCardsMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.zenflash.grpc.GetPendingCardsRequest,
              com.zenflash.grpc.GetPendingCardsResponse>(
                service, METHODID_GET_PENDING_CARDS)))
        .build();
  }

  private static abstract class NlpServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    NlpServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.zenflash.grpc.Zenflash.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("NlpService");
    }
  }

  private static final class NlpServiceFileDescriptorSupplier
      extends NlpServiceBaseDescriptorSupplier {
    NlpServiceFileDescriptorSupplier() {}
  }

  private static final class NlpServiceMethodDescriptorSupplier
      extends NlpServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    NlpServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (NlpServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new NlpServiceFileDescriptorSupplier())
              .addMethod(getAnalyzeSentenceMethod())
              .addMethod(getSubmitReviewMethod())
              .addMethod(getUpdateTranslationMethod())
              .addMethod(getGetDueCardsMethod())
              .addMethod(getGetPendingCardsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
