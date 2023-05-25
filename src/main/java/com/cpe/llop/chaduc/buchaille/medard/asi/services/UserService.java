package com.cpe.llop.chaduc.buchaille.medard.asi.services;

import com.cpe.llop.chaduc.buchaille.medard.asi.models.User;

public interface UserService {
    User getUserSummary(Long userId);

    User addUser(String username, String password, String email);

    User setUserMoney(long userId, Integer userMoney);

    public void addUserCard(/*@RequestBody AddUserCardRequest addUserCardRequest*/);

    User removeUserCard(Long userId);
}
