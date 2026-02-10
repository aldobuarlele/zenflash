package com.zenflash.grpc;

import com.atilika.kuromoji.ipadic.Token;
import com.atilika.kuromoji.ipadic.Tokenizer;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import lombok.extern.slf4j.Slf4j;
import java.util.List;

@Slf4j
@GrpcService
public class ZenFlashServer extends NlpServiceGrpc.NlpServiceImplBase {

    private final Tokenizer tokenizer = new Tokenizer();

    @Override
    public void analyzeSentence(AnalyzeRequest request, StreamObserver<AnalyzeResponse> responseObserver) {
        log.info("Analyzing Japanese text: {}", request.getText());

        List<Token> tokens = tokenizer.tokenize(request.getText());
        AnalyzeResponse.Builder responseBuilder = AnalyzeResponse.newBuilder();

        for (Token token : tokens) {
            com.zenflash.grpc.Token grpcToken = com.zenflash.grpc.Token.newBuilder()
                    .setSurface(token.getSurface())
                    .setReading(token.getReading() != null ? token.getReading() : "")
                    .setBaseForm(token.getBaseForm() != null ? token.getBaseForm() : "")
                    .setPartOfSpeech(token.getAllFeaturesArray()[0])
                    .build();

            responseBuilder.addTokens(grpcToken);
        }

        responseBuilder.setSentiment("Analyzed");

        responseObserver.onNext(responseBuilder.build());
        responseObserver.onCompleted();

        log.info("Analysis completed with {} tokens found", tokens.size());
    }
}