package com.zenflash.grpc;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@GrpcService
public class ZenFlashServer extends NlpServiceGrpc.NlpServiceImplBase {

    @Override
    public void analyzeSentence(AnalyzeRequest request, StreamObserver<AnalyzeResponse> responseObserver) {
        log.info("Received gRPC request with text: {}", request.getText());

        Token testToken = Token.newBuilder()
                .setSurface(request.getText())
                .setReading("test_reading")
                .setBaseForm("test_base")
                .setPartOfSpeech("Noun")
                .build();

        AnalyzeResponse response = AnalyzeResponse.newBuilder()
                .addTokens(testToken)
                .setSentiment("Testing_Active")
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();

        log.info("Successfully sent gRPC response");
    }
}