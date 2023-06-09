package com.cpe.llop.chaduc.buchaille.medard.asi.services;

import com.cpe.llop.chaduc.buchaille.medard.asi.models.Card;

import java.util.List;

public interface MarketService {
    public List<Card> GetAvailableCards();
    public Card GetCard(Long cardId);
    public boolean SellCard(Long cardId, String username);
    public boolean BuyCard(Long cardId, String username);
}
