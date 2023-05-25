package com.cpe.llop.chaduc.buchaille.medard.asi.repositories;

import com.cpe.llop.chaduc.buchaille.medard.asi.models.Card;

import com.cpe.llop.chaduc.buchaille.medard.asi.models.User;
import org.springframework.data.repository.CrudRepository;

public interface CardRepository extends CrudRepository<Card, Long> {
    Card findByName(String cardName);
}
