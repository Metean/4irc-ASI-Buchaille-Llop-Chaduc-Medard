package com.cpe.llop.chaduc.buchaille.medard.asi.services;

import com.cpe.llop.chaduc.buchaille.medard.asi.models.Card;
import com.cpe.llop.chaduc.buchaille.medard.asi.models.dto.CardFormDTO;
import org.springframework.data.domain.Page;

public interface CardService {
    Page<Card> getCardList();

    Page<Card> getCardList(Integer page, Integer size);

    Card getCard(int id);

    Card getRandomCard();

    Card addCard(float price, String name, String description, String imgUrl, String type1, String type2, int hp, int attack, int defense);

    boolean updateItem(Long cardId, CardFormDTO cardFormDTO);

    boolean createItem(CardFormDTO cardFormDTO);
}
