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

    //TODO: report the logic from the user controller here, (with the connection to the database)
    @Override
    public User getUser(@RequestParam("userId") Long userId) {
        Optional<User> u = userRepository.findById(userId);
        return u.orElse(null);
    }


    public User addUser(@RequestBody UserFormDTO userForm) {
        User u = new User(userForm.getUsername(), userForm.getPassword(), userForm.getEmail());
        userRepository.save(u);
        return u;
    }

    public void setUserMoney(UserMoneyFormDTO userMoneyForm) {
        User u = this.getUser(userMoneyForm.getUserId());
        u.setMoney(userMoneyForm.getMoney());
        userRepository.save(u);
    }

    public void addUserCard(/*@RequestBody AddUserCardRequest addUserCardRequest*/) {

    }

    public void removeUserCard(/*@RequestBody RemoveUserCardRequest removeUserCardRequest*/) {

    }

    public User checkUser(UserFormDTO userForm) {
        User u = userRepository.findByUsername(userForm.getUsername());
        if(u == null) {
            return null;
        }
        if(u.getPassword().equals(userForm.getPassword())) {
            return u;
        }
        return null;
    }
}