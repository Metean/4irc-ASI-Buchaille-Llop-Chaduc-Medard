package com.cpe.llop.chaduc.buchaille.medard.asi.services;

import com.cpe.llop.chaduc.buchaille.medard.asi.models.Card;
import com.cpe.llop.chaduc.buchaille.medard.asi.models.User;
import com.cpe.llop.chaduc.buchaille.medard.asi.models.dto.UserFormDTO;
import com.cpe.llop.chaduc.buchaille.medard.asi.models.dto.UserMoneyFormDTO;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface CardService {
    public List<Card> getCardList();
    public Card getCard(int id);
    public Card getRandomCard();
    public Card addCard(float price, String name, String description, String imgUrl, String type1, String type2, int hp, int attack, int defense);
}
