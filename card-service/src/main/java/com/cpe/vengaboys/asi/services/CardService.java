package com.cpe.vengaboys.asi.services;

import com.cpe.vengaboys.asi.models.Card;
import org.springframework.data.domain.Page;

public interface CardService {
    public Page<Card> getCardList();
    public Page<Card> getCardList(Integer page, Integer size);
    public Card getCard(int id);
    public Card getRandomCard();
    public Card addCard(float price, String name, String description, String imgUrl, String type1, String type2, int hp, int attack, int defense);
}
