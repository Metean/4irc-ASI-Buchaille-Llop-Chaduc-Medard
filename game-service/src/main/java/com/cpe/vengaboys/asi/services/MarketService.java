package com.cpe.vengaboys.asi.services;

import com.cpe.vengaboys.asi.models.Card;

import java.util.List;

public interface MarketService {
    public List<Card> GetAvailableCards();
    public Card GetCard(Long cardId);
    public boolean SellCard(Long cardId, String username);
    public boolean BuyCard(Long cardId, String username);
}
