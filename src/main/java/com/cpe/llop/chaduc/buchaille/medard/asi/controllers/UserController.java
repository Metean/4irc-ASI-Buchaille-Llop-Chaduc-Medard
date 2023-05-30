package com.cpe.llop.chaduc.buchaille.medard.asi.controllers;

import com.cpe.llop.chaduc.buchaille.medard.asi.annotations.ApiRestController;
import com.cpe.llop.chaduc.buchaille.medard.asi.models.User;
import com.cpe.llop.chaduc.buchaille.medard.asi.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@ApiRestController()
public class UserController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("user/")
    public ResponseEntity<?> getUser(@RequestParam Optional<String> username) {

        if (username.isPresent()) {
            User u = userService.getUser(username.get());
            if (u != null)
                return new ResponseEntity<>(u, HttpStatus.OK);
            else
                return (ResponseEntity<?>) ResponseEntity.notFound();

        }

        return new ResponseEntity<>(userService.getUsers(), HttpStatus.NOT_IMPLEMENTED);
    }

    @GetMapping("user/{id}/")
    public User getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }

    @PostMapping("register/")
    public ResponseEntity<?> register(@RequestBody String username, @RequestBody String password, @RequestBody String email) {
        User u = userService.addUser(username, password, email);

        if (u != null) {
            log.info("userID[{}] {} is register", u.getId(), username);
            return new ResponseEntity<>(u, HttpStatus.OK);
        }

        log.info("userID[None] {} already exists", username);
        return new ResponseEntity<>("Username already exists", HttpStatus.FORBIDDEN);
    }

    @PostMapping("login/")
    public ResponseEntity<?> login(@RequestBody String username, @RequestBody String password) {
        User u = userService.login(username, password);

        if (u != null) {
            log.info("userID[{}] {} is login", u.getId(), username);
            return new ResponseEntity<>(u, HttpStatus.OK);
        }

        log.info("userID[None] {} has invalid login credentials", username);
        return new ResponseEntity<>("Wrong username or password", HttpStatus.FORBIDDEN);
    }


    @PutMapping("user/{id}/{action}/")
    public ResponseEntity<?> updateUser(@PathVariable Long id, @PathVariable String action, @RequestParam("amount") Double amount) {

        switch (action) {
            case "add":
                userService.addUserMoney(id, amount);
                log.info("userID[{}]  gain {} money", id, amount);
                break;
            case "remove":
                userService.addUserMoney(id, -amount);
                log.info("userID[{}]  lose {} money", id, amount);
                break;
            default:
                log.info("userID[{}]  {} wrong parameters", "updateUser", id);
                return new ResponseEntity<>("Wrong action", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(userService.getUser(id), HttpStatus.OK);
    }

}

