package com.cpe.llop.chaduc.buchaille.medard.asi.services;

import com.cpe.llop.chaduc.buchaille.medard.asi.models.Card;
import com.cpe.llop.chaduc.buchaille.medard.asi.repositories.CardRepository;

public class CardServiceImpl implements CardService {

    CardRepository cardRepository;

    public CardServiceImpl(CardRepository userRepository) {
        this.cardRepository = userRepository;
    }


    @Override
    public Card getCardSummary(String name) {
        Card card = cardRepository.findByName(name);
        cardRepository.save(card);
        return card;
    }

    @Override
    public Card addCard(String name, int health, int attack, int defense) {
        Card card = new Card(name, health, attack, defense);
        cardRepository.save(card);
        return card;
    }

    @Override
    public Card removeUserCard(String name) {
        Card card = cardRepository.findByName(name);
        cardRepository.delete(card);
        return card;
    }
}
