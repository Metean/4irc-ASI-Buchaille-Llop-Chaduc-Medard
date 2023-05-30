package com.cpe.llop.chaduc.buchaille.medard.asi.services;

import com.cpe.llop.chaduc.buchaille.medard.asi.models.User;
import com.cpe.llop.chaduc.buchaille.medard.asi.models.dto.UserFormDTO;
import com.cpe.llop.chaduc.buchaille.medard.asi.models.dto.UserMoneyFormDTO;
import com.cpe.llop.chaduc.buchaille.medard.asi.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUser(Long userId) {
        Optional<User> u = userRepository.findById(userId);
        return u.orElse(null);
    }

    public User getUser(String username) {
        return userRepository.findByUsername(username);
    }

    public User addUser(String username, String password, String email) {
        User u = new User(username, password, email);
        userRepository.save(u);
        return u;
    }

    public void addUserMoney(@RequestParam("username") String username, @RequestParam("amount") Double amount) {
        User u = userRepository.findByUsername(username);
        u.setMoney(u.getMoney() + amount);
        userRepository.save(u);
    }

    public User login(String username, String password) {
        User user = userRepository.findByUsername(username);

        if (user != null && password.equals(user.getPassword()))
            return user;

        return null;
    }
}