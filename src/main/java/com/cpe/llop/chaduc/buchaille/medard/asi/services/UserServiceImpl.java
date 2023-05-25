package com.cpe.llop.chaduc.buchaille.medard.asi.services;

import com.cpe.llop.chaduc.buchaille.medard.asi.models.User;
import com.cpe.llop.chaduc.buchaille.medard.asi.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //TODO: report the logic from the user controller here, (with the connection to the database)
    @Override
    public User getUserSummary(Long userId) {
        return userRepository.getReferenceById(userId);
    }


    public User addUser(String username, String password, String email) {
        User user = new User(username, password, email);
        userRepository.save(user);
        return user;
    }

    @Override
    public User setUserMoney(long userId, Integer userMoney) {
        User user = userRepository.getReferenceById(userId);
        userRepository.save(user);
        return user;
    }

    public void addUserCard(/*@RequestBody AddUserCardRequest addUserCardRequest*/) {

    }

    public User removeUserCard(Long userId) {
        User user = userRepository.getReferenceById(userId);
        userRepository.delete(user);
        return user;
    }
}