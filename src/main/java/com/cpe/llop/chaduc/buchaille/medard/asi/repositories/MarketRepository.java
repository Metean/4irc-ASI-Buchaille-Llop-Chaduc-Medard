package com.cpe.llop.chaduc.buchaille.medard.asi.repositories;

import com.cpe.llop.chaduc.buchaille.medard.asi.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarketRepository extends JpaRepository<User, Long> {
}
