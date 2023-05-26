package com.cpe.llop.chaduc.buchaille.medard.asi.services;

import com.cpe.llop.chaduc.buchaille.medard.asi.models.Card;

public interface CardService {
    Card getCardSummary(String name);

    Card addCard(String name, int health, int attack, int defense);

    Card removeUserCard(String name);
}
