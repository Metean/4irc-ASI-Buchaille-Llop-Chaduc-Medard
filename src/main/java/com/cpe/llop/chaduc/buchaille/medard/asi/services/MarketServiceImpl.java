package com.cpe.llop.chaduc.buchaille.medard.asi.services;

import com.cpe.llop.chaduc.buchaille.medard.asi.models.Card;
import com.cpe.llop.chaduc.buchaille.medard.asi.models.User;
import com.cpe.llop.chaduc.buchaille.medard.asi.repositories.CardRepository;
import com.cpe.llop.chaduc.buchaille.medard.asi.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarketServiceImpl implements MarketService {

    private final CardRepository cardRepository;
    private final UserRepository userRepository;

    public MarketServiceImpl(CardRepository cardRepository, UserRepository userRepository) {
        this.cardRepository = cardRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<Card> GetAvailableCards() {
        return cardRepository.findByUserIsNull();
    }

    @Override
    public boolean SellCard(Long cardId, String username) {
        Card c = cardRepository.getReferenceById(cardId);
        User u = userRepository.findByUsername(username);

        c.setUser(null);
        u.setMoney(u.getMoney() + c.getPrice());
        cardRepository.save(c);
        return true;
    }

    @Override
    public boolean BuyCard(Long cardId, String username) {
        Card c = cardRepository.getReferenceById(cardId);
        User u = userRepository.findByUsername(username);

        if(u.getMoney() < c.getPrice())
            return false;

        c.setUser(u);
        cardRepository.save(c);
        return true;
    }
}
