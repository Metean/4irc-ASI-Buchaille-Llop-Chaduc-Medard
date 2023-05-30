package com.cpe.llop.chaduc.buchaille.medard.asi.dto;

public class BuyCardDto {
    private String username;
    private Long cardId;

    public BuyCardDto() {}

    public BuyCardDto(String username, Long cardId) {
        this.username = username;
        this.cardId = cardId;
    }
}
