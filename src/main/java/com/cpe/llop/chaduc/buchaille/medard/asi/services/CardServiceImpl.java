package com.cpe.llop.chaduc.buchaille.medard.asi.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.cpe.llop.chaduc.buchaille.medard.asi.models.Card;
import com.cpe.llop.chaduc.buchaille.medard.asi.repositories.CardRepository;
import org.springframework.stereotype.Service;

@Service
public class CardServiceImpl implements CardService {

    private Random randomGenerator;
    private CardRepository cardRepository;

    public CardServiceImpl(CardRepository cardRepository) {
        randomGenerator = new Random();
        this.cardRepository = cardRepository;
    }

    public List<Card> getCardList() {
        return this.cardRepository.findAll();
    }

    public Card getCard(int id){
        return this.cardRepository.findById((long) id).orElse(null);
    }

    public Card getRandomCard(){
        List<Card> cardList = this.cardRepository.findAll();
        if(cardList.size() == 0)
            return null;
        int index = randomGenerator.nextInt(cardList.size());
        return cardList.get(index);
    }

    public Card addCard(float price, String name, String description, String imgUrl, String type1,
                        String type2, int hp, int attack, int defense) {
        Card c = new Card(price, name, description, imgUrl, type1, type2, hp, attack, defense);
        return this.cardRepository.save(c);
    }
}
