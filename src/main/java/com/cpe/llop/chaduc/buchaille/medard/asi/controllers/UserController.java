package com.cpe.llop.chaduc.buchaille.medard.asi.controllers;

import com.cpe.llop.chaduc.buchaille.medard.asi.models.User;
import com.cpe.llop.chaduc.buchaille.medard.asi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/summary")
    public User/*UserSummaryResponse*/ getUserSummary(@RequestParam("userId") Long userId) {
        // Implement getUserSummary logic using the userService
        // Return the user summary response
        User ret = this.userService.getUserSummary(userId);
        log.info(ret.toString());
        return ret;
    }

    @PostMapping("/add")
    public void addUser(/*@RequestBody AddUserRequest addUserRequest*/) {
        this.userService.addUser();
    }

    @PostMapping("/money")
    public void setUserMoney(/*@RequestBody SetUserMoneyRequest setUserMoneyRequest*/) {
        // Implement setUserMoney logic using the userService
    }

    @PostMapping("/card/add")
    public void addUserCard(/*@RequestBody AddUserCardRequest addUserCardRequest*/) {
        // Implement addUserCard logic using the userService
    }

    @PostMapping("/card/remove")
    public void removeUserCard(/*@RequestBody RemoveUserCardRequest removeUserCardRequest*/) {
        // Implement removeUserCard logic using the userService
    }
}

