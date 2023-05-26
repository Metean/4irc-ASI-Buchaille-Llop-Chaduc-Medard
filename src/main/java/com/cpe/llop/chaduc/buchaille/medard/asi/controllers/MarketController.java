package com.cpe.llop.chaduc.buchaille.medard.asi.controllers;

import com.cpe.llop.chaduc.buchaille.medard.asi.models.Card;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/market")
public class MarketController {

    private final CardDAO cardDAO;
    public MarketController(CardDAO cardDAO){
        this.cardDAO = cardDAO;
    }

    @GetMapping("/getAllCards")
    public List<Card> GetAllCards() {
        return cardDAO.getAllCards();
    }
}
