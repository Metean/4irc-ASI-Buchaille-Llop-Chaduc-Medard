package com.cpe.vengaboys.asi.repositories;

import com.cpe.vengaboys.asi.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
