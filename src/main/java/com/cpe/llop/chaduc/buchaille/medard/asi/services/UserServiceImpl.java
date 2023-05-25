package com.cpe.llop.chaduc.buchaille.medard.asi.services;

import com.cpe.llop.chaduc.buchaille.medard.asi.models.User;
import com.cpe.llop.chaduc.buchaille.medard.asi.models.dto.UserFormDTO;
import com.cpe.llop.chaduc.buchaille.medard.asi.models.dto.UserMoneyFormDTO;
import com.cpe.llop.chaduc.buchaille.medard.asi.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //TODO: report the logic from the user controller here, (with the connection to the database)
    @Override
    public User getUser(@RequestParam("userId") Long userId) {
        try {
            User u = userRepository.getReferenceById(userId);
            if(u.getClass() != User.class) {
                throw new EntityNotFoundException();
            }
            return u;
        } catch (Throwable e) {
            return null;
        }
    }


    public void addUser(@RequestBody UserFormDTO userForm) {
        User u = new User(userForm.getUsername(), userForm.getPassword(), userForm.getEmail());
        userRepository.save(u);
    }

    public void setUserMoney(/*@RequestBody SetUserMoneyRequest setUserMoneyRequest*/) {

    }

    public void addUserCard(/*@RequestBody AddUserCardRequest addUserCardRequest*/) {

    }

    public void removeUserCard(/*@RequestBody RemoveUserCardRequest removeUserCardRequest*/) {

    }
}