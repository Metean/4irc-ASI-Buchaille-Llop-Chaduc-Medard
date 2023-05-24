package com.cpe.llop.chaduc.buchaille.medard.asi.services;

import com.cpe.llop.chaduc.buchaille.medard.asi.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository  userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //TODO: report the logic from the user controller here, (with the connection to the database)
    public void/*UserSummaryResponse*/ getUserSummary(@RequestParam("userId") String userId) {

    }

    public void addUser(/*@RequestBody AddUserRequest addUserRequest*/) {

    }

    public void setUserMoney(/*@RequestBody SetUserMoneyRequest setUserMoneyRequest*/) {

    }

    public void addUserCard(/*@RequestBody AddUserCardRequest addUserCardRequest*/) {

    }

    public void removeUserCard(/*@RequestBody RemoveUserCardRequest removeUserCardRequest*/) {

    }
}