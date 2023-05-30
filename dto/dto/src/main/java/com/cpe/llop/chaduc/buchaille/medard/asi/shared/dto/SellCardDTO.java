package com.cpe.llop.chaduc.buchaille.medard.asi.dto;

public class SellCardDto {
    private String username;
    private Long cardId;

    public SellCardDto() {}

    public SellCardDto(String username, Long cardId) {
        this.username = username;
        this.cardId = cardId;
    }
}
