package com.cpe.llop.chaduc.buchaille.medard.asi.controllers;

import com.cpe.llop.chaduc.buchaille.medard.asi.models.Card;
import com.cpe.llop.chaduc.buchaille.medard.asi.services.CardService;
import com.cpe.llop.chaduc.buchaille.medard.asi.services.MarketService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/market")
public class MarketController {

    private final CardService cardService;
    private final MarketService marketService;

    public MarketController(CardService cardDAO, MarketService marketService) {
        this.marketService = marketService;
        this.cardService = cardDAO;
    }

    @GetMapping("/getAllCards")
    public List<Card> GetAllCards() {
        return cardService.getCardList();
    }

    @GetMapping("/getAvailableCards")
    public List<Card> GetAvailable() {
        return marketService.GetAvailableCards();
    }

    @PostMapping("/sell")
    public ResponseEntity SellCard(@RequestParam("username") String username, @RequestParam("CardId") Long cardId) {
        return marketService.SellCard(cardId, username) ? (ResponseEntity) ResponseEntity.ok() : new ResponseEntity<>("Card does not exist or user does not have required money", HttpStatus.FORBIDDEN);
    }

    @PostMapping("/buy")
    public ResponseEntity BuyCard(@RequestParam("username") String username, @RequestParam("CardId") Long cardId) {
        return marketService.BuyCard(cardId, username) ? (ResponseEntity) ResponseEntity.ok() : new ResponseEntity<>("Card does not exist", HttpStatus.FORBIDDEN);
    }
}