package com.cpe.vengaboys.asi.controllers;

import com.cpe.vengaboys.asi.annotations.ApiRestController;
import com.cpe.vengaboys.asi.services.CardService;
import com.cpe.vengaboys.asi.shared.dto.CardDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@ApiRestController()
public class CardController {
    private final CardService cardService;

    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @GetMapping("cards/available/") // Je ne sais pas si ça respecte le standard REST
    public List<CardDto> GetAvailable() {
        return cardService.GetAvailableCards();
    }

    @GetMapping("cards/{id}/")
    public CardDto GetCard(@PathVariable("id") Long id) {
        return cardService.GetCard(id);
    }

    @PutMapping("cards/{idCard}/{action}/")
    public ResponseEntity<?> SellCard(@PathVariable Long idCard, @PathVariable String action, @RequestBody Long userId) {
        if (action == "sell")
            cardService.SellCard(idCard, userId);
        else if (action == "buy")
            return  cardService.BuyCard(idCard, userId) ? (ResponseEntity<?>) ResponseEntity.ok() : new ResponseEntity<>("Card does not exist", HttpStatus.FORBIDDEN);

        return new ResponseEntity<>("`action` field must have sell or buy", HttpStatus.BAD_REQUEST);
    }
}
