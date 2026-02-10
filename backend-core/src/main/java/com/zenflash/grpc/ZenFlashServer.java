package com.zenflash.grpc;

import com.atilika.kuromoji.ipadic.Token;
import com.atilika.kuromoji.ipadic.Tokenizer;
import com.zenflash.domain.Card;
import com.zenflash.repository.CardRepository;
import com.zenflash.service.SrsService;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.server.service.GrpcService;
import lombok.extern.slf4j.Slf4j;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

@Slf4j
@GrpcService
@RequiredArgsConstructor
public class ZenFlashServer extends NlpServiceGrpc.NlpServiceImplBase {

    private final Tokenizer tokenizer = new Tokenizer();
    private final CardRepository cardRepository;
    private final SrsService srsService;

    @Override
    public void analyzeSentence(AnalyzeRequest request, StreamObserver<AnalyzeResponse> responseObserver) {
        log.info("Ingesting and analyzing: {}", request.getText());

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

        Card newCard = Card.builder()
                .frontText(request.getText())
                .backText("Pending Translation")
                .reading("Analyzed")
                .nextReviewAt(ZonedDateTime.now())
                .build();

        Card savedCard = cardRepository.save(newCard);
        log.info("New card saved to DB with ID: {}", savedCard.getId());

        responseBuilder.setSentiment("SAVED_ID_" + savedCard.getId());

        responseObserver.onNext(responseBuilder.build());
        responseObserver.onCompleted();
    }

    @Override
    public void submitReview(ReviewRequest request, StreamObserver<ReviewResponse> responseObserver) {
        log.info("Processing review for card: {}", request.getCardId());

        Card card = cardRepository.findById(UUID.fromString(request.getCardId()))
                .orElseThrow(() -> new RuntimeException("Card not found"));

        Card updatedCard = srsService.calculateNextReview(card, request.getQualityScore());
        cardRepository.save(updatedCard);

        ReviewResponse response = ReviewResponse.newBuilder()
                .setNextReviewDate(updatedCard.getNextReviewAt().toString())
                .setMessage("SRS algorithm updated successfully")
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();

        log.info("Card {} scheduled for next review at {}", updatedCard.getId(), updatedCard.getNextReviewAt());
    }
}