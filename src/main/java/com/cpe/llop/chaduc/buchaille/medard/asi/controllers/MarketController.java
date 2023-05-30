package com.cpe.llop.chaduc.buchaille.medard.asi.controllers;

import com.cpe.llop.chaduc.buchaille.medard.asi.annotations.ApiRestController;
import com.cpe.llop.chaduc.buchaille.medard.asi.models.Card;
import com.cpe.llop.chaduc.buchaille.medard.asi.services.CardService;
import com.cpe.llop.chaduc.buchaille.medard.asi.services.MarketService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@ApiRestController
public class MarketController {
    private static final Logger log = LoggerFactory.getLogger(MarketController.class);

    private final CardService cardService;
    private final MarketService marketService;

    public MarketController(CardService cardDAO, MarketService marketService) {
        this.marketService = marketService;
        this.cardService = cardDAO;
    }

    @GetMapping("market/")
    public Page<Card> GetAllCards(@RequestParam Optional<Integer> page, @RequestParam Optional<Integer> size) {
        if (page.isPresent() && size.isPresent())
            return cardService.getCardList(page.get(), size.get());
        return cardService.getCardList();
    }

    @GetMapping("market/available/") // Je ne sais pas si ça respecte le standard REST
    public List<Card> GetAvailable() {
        return marketService.GetAvailableCards();
    }

    @GetMapping("market/{id}/")
    public Card GetAvailable(@PathVariable("id") Long id) {
        return marketService.GetCard(id);
    }


    @PutMapping("market/{idCard}/{action}/")
    public ResponseEntity<?> SellCard(@PathVariable Long idCard, @PathVariable String action,@RequestParam("idUser") Long idUser) {

        return switch (action) {
            case "sell" ->
                    marketService.SellCard(idCard, idUser) ? (ResponseEntity<?>) ResponseEntity.ok() : new ResponseEntity<>("Card does not exist or user does not have required money", HttpStatus.FORBIDDEN);
            case "buy" ->
                    marketService.BuyCard(idCard, idUser) ? (ResponseEntity<?>) ResponseEntity.ok() : new ResponseEntity<>("Card does not exist", HttpStatus.FORBIDDEN);
            default -> new ResponseEntity<>("`action` field must have sell or buy", HttpStatus.BAD_REQUEST);
        };

    }

}
