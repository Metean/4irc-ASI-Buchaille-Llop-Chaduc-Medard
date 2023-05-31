package com.cpe.vengaboys.asi.shared.dto;

public class SellCardDto {
    private String username;
    private Long cardId;

    public SellCardDto() {}

    public SellCardDto(String username, Long cardId) {
        this.username = username;
        this.cardId = cardId;
    }
}
