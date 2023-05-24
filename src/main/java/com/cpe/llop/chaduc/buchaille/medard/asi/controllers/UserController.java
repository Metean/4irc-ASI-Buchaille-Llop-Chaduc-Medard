package com.cpe.llop.chaduc.buchaille.medard.asi.controllers;

import com.cpe.llop.chaduc.buchaille.medard.asi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/summary")
    public void/*UserSummaryResponse*/ getUserSummary(@RequestParam("userId") String userId) {
        // Implement getUserSummary logic using the userService
        // Return the user summary response
    }

    @PostMapping("/add")
    public void addUser(/*@RequestBody AddUserRequest addUserRequest*/) {
        // Implement addUser logic using the userService
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

