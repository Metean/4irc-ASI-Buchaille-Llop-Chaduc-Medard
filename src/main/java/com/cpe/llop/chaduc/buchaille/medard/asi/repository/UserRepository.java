package com.cpe.llop.chaduc.buchaille.medard.asi.repository;

import com.cpe.llop.chaduc.buchaille.medard.asi.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
    public User findByUsername(String username);
}
