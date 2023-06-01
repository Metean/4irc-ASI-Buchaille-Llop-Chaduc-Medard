package com.cpe.vengaboys.asi.controllers;

import com.cpe.vengaboys.asi.annotations.ApiRestController;
import com.cpe.vengaboys.asi.exception.AuthenticationException;
import com.cpe.vengaboys.asi.exception.LoginException;
import com.cpe.vengaboys.asi.exception.RegisterException;
import com.cpe.vengaboys.asi.services.UserService;
import com.cpe.vengaboys.shared.dto.LoginDto;
import com.cpe.vengaboys.shared.dto.RegisterDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@ApiRestController()
public class AuthenticationController {
    UserService userService;

    public AuthenticationController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public String register(@RequestBody RegisterDto userForm) throws RegisterException {
        return this.userService.register(userForm);
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginDto userForm) throws LoginException {
        return this.userService.login(userForm);
    }

    @PostMapping("/authenticate")
    public Boolean authenticate(@RequestHeader("Authorization") String authorisationToken) throws AuthenticationException {
        if (!this.userService.authenticate(authorisationToken)) {
            throw new AuthenticationException();
        }
        return true;
    }
}

