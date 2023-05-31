package com.cpe.llop.chaduc.buchaille.medard.asi.services;

import com.cpe.llop.chaduc.buchaille.medard.asi.importer.PokemonImporter;
import com.cpe.llop.chaduc.buchaille.medard.asi.models.Card;
import com.cpe.llop.chaduc.buchaille.medard.asi.models.dto.CardFormDTO;
import com.cpe.llop.chaduc.buchaille.medard.asi.repositories.CardRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class CardServiceImpl implements CardService {

    private final Random randomGenerator;
    private final CardRepository cardRepository;
    private final MapperService mapperService;

    public CardServiceImpl(CardRepository cardRepository, MapperService mapperService) {
        randomGenerator = new Random();
        this.cardRepository = cardRepository;
        this.mapperService = mapperService;


        if (this.cardRepository.findAll().isEmpty())
            this.cardRepository.saveAll(new PokemonImporter().getPokemonCards());
    }

    public Page<Card> getCardList() {
        return this.cardRepository.findAll(PageRequest.of(0, 100));
    }

    public Page<Card> getCardList(Integer page, Integer size) {
        return this.cardRepository.findAll(PageRequest.of(page, size));
    }

    public Card getCard(int id) {
        return this.cardRepository.findById((long) id).orElse(null);
    }

    public Card getRandomCard() {
        List<Card> cardList = this.cardRepository.findAll();
        if (cardList.size() == 0)
            return null;
        int index = randomGenerator.nextInt(cardList.size());
        return cardList.get(index);
    }

    public Card addCard(float price, String name, String description, String imgUrl, String type1,
                        String type2, int hp, int attack, int defense) {
        Card c = new Card(price, name, description, imgUrl, type1, type2, hp, attack, defense);
        return this.cardRepository.save(c);
    }

    @Override
    public boolean updateItem(Long cardId, CardFormDTO cardFormDTO) {
        Card c = cardRepository.getReferenceById(cardId);


        cardRepository.save(c);
        return true;
    }

    @Override
    public boolean createItem(CardFormDTO cardFormDTO) {
        Card c = new Card();

        mapperService.map(cardFormDTO, c);

        cardRepository.save(c);
        return true;
    }
}
