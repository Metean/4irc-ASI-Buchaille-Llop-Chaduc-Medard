package com.cpe.llop.chaduc.buchaille.medard.asi.services;

import com.cpe.llop.chaduc.buchaille.medard.asi.repositories.MarketRepository;
import com.cpe.llop.chaduc.buchaille.medard.asi.repositories.UserRepository;

public class MarketServiceImpl implements MarketService {

    private final MarketRepository marketRepository;

    public MarketServiceImpl(MarketRepository marketRepository) {
        this.marketRepository = marketRepository;
    }

    @Override
    public ArrayList<Card> GetAvailableCards() {

        return marketRepository.

        return null;
    }

    @Override
    public void SellCard(String cardId, String username) {

    }

    @Override
    public void BuyCard(String cardId, String username) {

    }
}
