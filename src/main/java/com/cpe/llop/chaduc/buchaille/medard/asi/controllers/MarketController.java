package com.cpe.llop.chaduc.buchaille.medard.asi.controllers;

import com.cpe.llop.chaduc.buchaille.medard.asi.models.Card;
import com.cpe.llop.chaduc.buchaille.medard.asi.services.CardService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/market")
public class MarketController {

    private final CardService cardDAO;
    public MarketController(CardService cardDAO){
        this.cardDAO = cardDAO;
    }

    @GetMapping("/getAllCards")
    public List<Card> GetAllCards() {
        return cardDAO.getCardList();
    }
}
