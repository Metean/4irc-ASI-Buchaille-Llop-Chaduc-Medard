package com.cpe.llop.chaduc.buchaille.medard.asi.services;

import com.cpe.llop.chaduc.buchaille.medard.asi.models.User;
import org.springframework.web.bind.annotation.RequestParam;

public interface UserService {
    public User getUser(@RequestParam("userId") Long userId);

    public void addUser(/*@RequestBody AddUserRequest addUserRequest*/);

    public void setUserMoney(/*@RequestBody SetUserMoneyRequest setUserMoneyRequest*/);

    public void addUserCard(/*@RequestBody AddUserCardRequest addUserCardRequest*/);

    public void removeUserCard(/*@RequestBody RemoveUserCardRequest removeUserCardRequest*/);
}
