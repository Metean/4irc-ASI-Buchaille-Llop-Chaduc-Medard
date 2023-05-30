package com.cpe.llop.chaduc.buchaille.medard.asi.repositories;

import com.cpe.llop.chaduc.buchaille.medard.asi.models.Card;
import com.cpe.llop.chaduc.buchaille.medard.asi.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface CardRepository extends PagingAndSortingRepository<Card, Long>, JpaRepository<Card, Long> {
    List<Card> findByUserIsNull();
}
