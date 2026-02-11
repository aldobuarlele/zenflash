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

    @Override
    public void updateTranslation(UpdateTranslationRequest request, StreamObserver<UpdateTranslationResponse> responseObserver) {
        log.info("Menerima pembaruan terjemahan untuk kartu ID: {}", request.getCardId());

        try {
            java.util.UUID uuid = java.util.UUID.fromString(request.getCardId());

            cardRepository.findById(uuid).ifPresentOrElse(card -> {
                card.setBackText(request.getTranslatedText());
                cardRepository.save(card);
                log.info("Terjemahan berhasil diperbarui di database.");

                responseObserver.onNext(UpdateTranslationResponse.newBuilder()
                        .setSuccess(true)
                        .setMessage("Translation updated successfully in PostgreSQL")
                        .build());
            }, () -> {
                log.warn("Kartu dengan ID {} tidak ditemukan.", request.getCardId());
                responseObserver.onNext(UpdateTranslationResponse.newBuilder()
                        .setSuccess(false)
                        .setMessage("Card ID not found")
                        .build());
            });
        } catch (Exception e) {
            log.error("Gagal update terjemahan: {}", e.getMessage());
            responseObserver.onNext(UpdateTranslationResponse.newBuilder()
                    .setSuccess(false)
                    .setMessage("Error: " + e.getMessage())
                    .build());
        }

        responseObserver.onCompleted();
    }

    @Override
    public void getDueCards(GetDueCardsRequest request, StreamObserver<GetDueCardsResponse> responseObserver) {
        log.info("Menarik daftar kartu yang jatuh tempo (Limit: {})", request.getLimit());

        try {
            ZonedDateTime now = ZonedDateTime.now();

            List<Card> dueCards = cardRepository.findCardsToReview(now);

            int limit = request.getLimit() > 0 ? request.getLimit() : dueCards.size();

            GetDueCardsResponse.Builder responseBuilder = GetDueCardsResponse.newBuilder();

            dueCards.stream()
                    .limit(limit)
                    .forEach(card -> {
                        DueCard grpcDueCard = DueCard.newBuilder()
                                .setCardId(card.getId().toString())
                                .setFrontText(card.getFrontText())
                                .setBackText(card.getBackText())
                                .build();
                        responseBuilder.addCards(grpcDueCard);
                    });

            responseObserver.onNext(responseBuilder.build());
            log.info("Berhasil mengirim {} kartu ke antrean belajar.", responseBuilder.getCardsCount());

        } catch (Exception e) {
            log.error("Gagal menarik kartu jatuh tempo: {}", e.getMessage());
        }

        responseObserver.onCompleted();
    }

    @Override
    public void getPendingCards(GetPendingCardsRequest request, StreamObserver<GetPendingCardsResponse> responseObserver) {
        log.info("AI Worker meminta daftar kartu 'Pending Translation' (Limit: {})", request.getLimit());

        try {
            List<Card> pendingEntities = cardRepository.findByBackText("Pending Translation");

            GetPendingCardsResponse.Builder responseBuilder = GetPendingCardsResponse.newBuilder();

            pendingEntities.stream()
                    .limit(request.getLimit() > 0 ? request.getLimit() : 100)
                    .forEach(card -> {
                        PendingCard pc = PendingCard.newBuilder()
                                .setCardId(card.getId().toString())
                                .setTextToTranslate(card.getFrontText())
                                .build();
                        responseBuilder.addCards(pc);
                    });

            responseObserver.onNext(responseBuilder.build());
            log.info("Mengirim {} kartu pending ke AI Worker.", responseBuilder.getCardsCount());

        } catch (Exception e) {
            log.error("Gagal mengambil kartu pending: {}", e.getMessage());
        }

        responseObserver.onCompleted();
    }

}