package com.cpe.vengaboys.asi.repositories;

import com.cpe.vengaboys.asi.models.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface CardRepository extends PagingAndSortingRepository<Card, Long>, JpaRepository<Card, Long> {
    List<Card> findByUserIsNull();
}
