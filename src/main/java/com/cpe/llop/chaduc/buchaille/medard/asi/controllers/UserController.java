package com.cpe.llop.chaduc.buchaille.medard.asi.controllers;

import com.cpe.llop.chaduc.buchaille.medard.asi.models.User;
import com.cpe.llop.chaduc.buchaille.medard.asi.models.dto.UserFormDTO;
import com.cpe.llop.chaduc.buchaille.medard.asi.services.UserService;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable("id") Long id) {
        User ret = this.userService.getUser(id);
        log.info(ret.toString());
        return ret;
    }

    @GetMapping("/register")
    public String register(@NotNull Model model) {
        UserFormDTO userForm = new UserFormDTO();
        model.addAttribute("userForm", userForm);
        return "userForm";
    }

    @PostMapping("/register")
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

