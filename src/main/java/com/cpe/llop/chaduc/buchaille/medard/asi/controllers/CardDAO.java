package com.cpe.llop.chaduc.buchaille.medard.asi.controllers;

import java.util.List;
import java.util.Random;

import com.cpe.llop.chaduc.buchaille.medard.asi.models.Card;
import com.cpe.llop.chaduc.buchaille.medard.asi.repositories.CardRepository;
import org.springframework.stereotype.Service;

@Service
public class CardDAO {
    private Random random;
    private final CardRepository cardRepository;

    public CardDAO(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
        random = new Random();
        createCardList();
    }

    private void createCardList() {
        //TODO implement the creation.
    }

    public List<Card> getAllCards() {
        return cardRepository.findAll();
    }

    public Card getRandomCard() {
        long cardCount = cardRepository.count();
        int randomIndex = random.nextInt((int) cardCount);

        List<Card> allCards = cardRepository.findAll();
        return allCards.get(randomIndex);
    }

    public Card addCard(float price, String name, String description, String imgUrl, String type1,
                        String type2, int hp, int attack, int defense) {
        Card c = new Card(price, name, description, imgUrl, type1, type2, hp, attack, defense);
        cardRepository.save(c);
        return c;
    }
}
