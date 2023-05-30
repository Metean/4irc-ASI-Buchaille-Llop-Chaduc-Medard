package com.cpe.llop.chaduc.buchaille.medard.asi.controllers;

import com.cpe.llop.chaduc.buchaille.medard.asi.annotations.ApiRestController;
import com.cpe.llop.chaduc.buchaille.medard.asi.models.User;
import com.cpe.llop.chaduc.buchaille.medard.asi.models.dto.UserFormDTO;
import com.cpe.llop.chaduc.buchaille.medard.asi.models.dto.UserMoneyFormDTO;
import com.cpe.llop.chaduc.buchaille.medard.asi.services.UserService;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ApiRestController()
public class UserController {

    private final UserService userService;
    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user/{username}")
    public User getUser(@RequestParam("username") String username) {
        return userService.getUser(username);
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("email") String email) {
        User u = userService.addUser(username, password, email);

        if (u != null)
            return new ResponseEntity<>(u, HttpStatus.OK);

        return new ResponseEntity<>("Username already exists", HttpStatus.FORBIDDEN);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestParam("username") String username, @RequestParam("password") String password) {
        User u = userService.login(username, password);

        if (u != null)
            return new ResponseEntity<>(u, HttpStatus.OK);

        return new ResponseEntity<>("wrong username or password", HttpStatus.FORBIDDEN);
    }

    @GetMapping("/user/{username}/money")
    public ResponseEntity<?> getUserMoney(@RequestParam("username") String username) {
        User u = userService.getUser(username);
        if (u != null)
            return new ResponseEntity<>(u.getMoney(), HttpStatus.OK);

        return new ResponseEntity<>("user does not exist", HttpStatus.FORBIDDEN);
    }

    @PostMapping("/user/{username}/money/add")
    public User addUserMoney(@RequestParam("username") String username, @RequestParam("amount") Double amount) {
        userService.addUserMoney(username, amount);
        return userService.getUser(username);
    }
}

