package com.cpe.llop.chaduc.buchaille.medard.asi.services;

public interface MarketService {
    public ArrayList<Card> GetAvailableCards();
    public void SellCard(String cardId, String username);
    public void BuyCard(String cardId, String username);
}
