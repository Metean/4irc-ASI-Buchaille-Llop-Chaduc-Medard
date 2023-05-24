package com.cpe.llop.chaduc.buchaille.medard.asi.services;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

public interface UserService {
    public void /*UserSummaryResponse*/ getUserSummary(@RequestParam("userId") String userId);

    public void addUser(/*@RequestBody AddUserRequest addUserRequest*/);

    public void setUserMoney(/*@RequestBody SetUserMoneyRequest setUserMoneyRequest*/);

    public void addUserCard(/*@RequestBody AddUserCardRequest addUserCardRequest*/);

    public void removeUserCard(/*@RequestBody RemoveUserCardRequest removeUserCardRequest*/);
}
