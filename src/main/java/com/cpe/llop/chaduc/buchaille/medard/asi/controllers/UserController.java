package com.cpe.llop.chaduc.buchaille.medard.asi.controllers;

import com.cpe.llop.chaduc.buchaille.medard.asi.models.User;
import com.cpe.llop.chaduc.buchaille.medard.asi.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

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
        return this.userService.getUserSummary(userId);
    }

    @PostMapping("/add")
    public User addUser(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        @RequestParam("email") String email) {

        return this.userService.addUser(username, password, email);
    }

    @PostMapping("/money")
    public User setUserMoney(@RequestParam("userId") long userId, @RequestParam("money") Integer userMoney) {
        return this.userService.setUserMoney(userId, userMoney);

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

