package com.cpe.vengaboys.asi.services;

import com.cpe.vengaboys.asi.models.Card;
import com.cpe.vengaboys.asi.shared.dto.CardDto;

import java.util.List;

public interface CardService {
    public List<CardDto> GetAvailableCards();
    public CardDto GetCard(Long cardId);
    public void SellCard(Long cardId, Long userId);
    public boolean BuyCard(Long cardId, Long userId);
}
