package com.cpe.llop.chaduc.buchaille.medard.asi.services;

import com.cpe.llop.chaduc.buchaille.medard.asi.models.User;
import com.cpe.llop.chaduc.buchaille.medard.asi.repositories.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
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

    @Override
    public Page<User> getUsers(Integer page, Integer size) {
        return userRepository.findAll(PageRequest.of(page, size));
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User getUser(String username) {
        return userRepository.findByUsername(username);
    }

    public User addUser(String username, String password, String email) {
        User u = new User(username, password, email);
        userRepository.save(u);
        return u;
    }

    public void addUserMoney(@RequestParam Long id, @RequestParam Double amount) {
        User u = userRepository.getReferenceById(id);
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