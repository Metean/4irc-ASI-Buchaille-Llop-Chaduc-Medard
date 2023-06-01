package com.cpe.vengaboys.asi.services;

import com.cpe.vengaboys.asi.models.Card;
import com.cpe.vengaboys.asi.models.User;
import com.cpe.vengaboys.asi.repositories.CardRepository;
import com.cpe.vengaboys.asi.shared.dto.CardDto;
import com.cpe.vengaboys.asi.shared.service.MapperService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CardServiceImpl implements CardService {
    private final CardRepository cardRepository;
    private final UserService userService;
    private final MapperService mapperService;

    public CardServiceImpl(CardRepository cardRepository, UserService userService, MapperService mapperService) {
        this.cardRepository = cardRepository;
        this.userService = userService;
        this.mapperService = mapperService;
    }

    @Override
    public List<CardDto> GetAvailableCards() {
        List<Card> cards = cardRepository.findByUserIsNull();
        List<CardDto> cardDtos = new ArrayList<>();
        for(Card card: cards){
            CardDto dto = new CardDto();
            mapperService.map(card, dto);
            cardDtos.add(dto);
        }
        return cardDtos;
    }


    @Override
    public CardDto GetCard(Long cardId) {
        CardDto c = new CardDto();
        mapperService.map(cardRepository.getReferenceById(cardId), c);
        return c;
    }

    @Override
    public void SellCard(Long cardId, Long userId) {
        User u = new User();
        mapperService.map(userService.getUser(userId), u);
        Card c = cardRepository.getReferenceById(cardId);

        c.setUser(null);
        userService.setUserMoney(u.getId(), u.getMoney() + c.getPrice());
        u.setMoney(u.getMoney() + c.getPrice());
        cardRepository.save(c);
    }

    @Override
    public boolean BuyCard(Long cardId, Long userId) {
        User u = new User();
        mapperService.map(userService.getUser(userId), u);
        Card c = cardRepository.getReferenceById(cardId);

        if(u.getMoney() < c.getPrice())
            return false;

        c.setUser(u);
        userService.setUserMoney(u.getId(), u.getMoney() - c.getPrice());
        cardRepository.save(c);
        return true;
    }
}
