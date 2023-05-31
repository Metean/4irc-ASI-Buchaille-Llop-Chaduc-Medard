package com.cpe.vengaboys.asi.controllers;

import com.cpe.vengaboys.asi.annotations.ApiRestController;
import com.cpe.vengaboys.asi.models.Card;
import com.cpe.vengaboys.asi.services.CardService;
import com.cpe.vengaboys.asi.services.MarketService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@ApiRestController()
public class MarketController {

    private final CardService cardService;
    private final MarketService marketService;

    public MarketController(CardService cardDAO, MarketService marketService) {
        this.marketService = marketService;
        this.cardService = cardDAO;
    }

    @GetMapping("/market/getAllCards")
    public Page<Card> GetAllCards(@RequestParam Optional<Integer> page, @RequestParam Optional<Integer> size) {
        if (page.isPresent() && size.isPresent())
            return cardService.getCardList(page.get(), size.get());
        return cardService.getCardList();
    }

    @GetMapping("/market/getAvailableCards")
    public List<Card> GetAvailable() {
        return marketService.GetAvailableCards();
    }

    @GetMapping("/market/getCard/{id}")
    public Card GetAvailable(@PathVariable("id") Long id) {
        return marketService.GetCard(id);
    }

    @PostMapping("/market/sell")
    public ResponseEntity SellCard(@RequestParam("username") String username, @RequestParam("CardId") Long cardId) {
        return marketService.SellCard(cardId, username) ? (ResponseEntity) ResponseEntity.ok() : new ResponseEntity<>("Card does not exist or user does not have required money", HttpStatus.FORBIDDEN);
    }

    @PostMapping("/market/buy")
    public ResponseEntity BuyCard(@RequestParam("username") String username, @RequestParam("CardId") Long cardId) {
        return marketService.BuyCard(cardId, username) ? (ResponseEntity) ResponseEntity.ok() : new ResponseEntity<>("Card does not exist", HttpStatus.FORBIDDEN);
    }
}
