package com.cpe.llop.chaduc.buchaille.medard.asi.controllers;

import com.cpe.llop.chaduc.buchaille.medard.asi.annotations.ApiRestController;
import com.cpe.llop.chaduc.buchaille.medard.asi.models.User;
import com.cpe.llop.chaduc.buchaille.medard.asi.models.dto.UserFormDTO;
import com.cpe.llop.chaduc.buchaille.medard.asi.models.dto.UserMoneyFormDTO;
import com.cpe.llop.chaduc.buchaille.medard.asi.services.UserService;
import jakarta.validation.constraints.NotNull;
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

    @GetMapping("/user/{id}")
    public String getUser(@NotNull Model model, @PathVariable("id") Long id) {
        User ret = this.userService.getUser(id);
        if(ret == null) {
            return "redirect:/login";
        }
        model.addAttribute("user", ret);
        return "userView";
    }

    @GetMapping("/register")
    public String registerView(@NotNull Model model) {
        UserFormDTO userForm = new UserFormDTO();
        model.addAttribute("userForm", userForm);
        return "userRegisterForm";
    }

    @PostMapping("/register")
    public String register(UserFormDTO userForm) {
        User u = this.userService.addUser(userForm);
        return  "redirect:/user/" + u.getId();
    }


    @GetMapping("/login")
    public String loginView(@NotNull Model model) {
        UserFormDTO userForm = new UserFormDTO();
        model.addAttribute("userForm", userForm);
        return "userLoginForm";
    }

    @PostMapping("/login")
    public String login(UserFormDTO userForm) {
        User u = this.userService.checkUser(userForm);
        return  "redirect:/user/" + u.getId();
    }

    @GetMapping("/user/{id}/money")
    public String userMoneyView(@NotNull Model model, @PathVariable("id") Long id) {
        User u = this.userService.getUser(id);
        if(u == null) {
            return "redirect:/login";
        }
        UserMoneyFormDTO userMoneyForm = new UserMoneyFormDTO();
        model.addAttribute("user", u);
        model.addAttribute("userMoneyForm", userMoneyForm);
        return "userMoneyForm";
    }

    @PostMapping("/user/{id}/money")
    public String userMoneyView(@NotNull Model model, @PathVariable("id") Long id, UserMoneyFormDTO userMoneyForm) {
        User u = this.userService.getUser(id);
        if(u == null) {
            return "redirect:/login";
        }
        userMoneyForm.setMoney(userMoneyForm.getMoney() + u.getMoney());
        userMoneyForm.setUserId(u.getId());
        this.userService.setUserMoney(userMoneyForm);
        return "redirect:/user/" + id;
    }

    @PostMapping("/user/card/add")
    public void addUserCard(/*@RequestBody AddUserCardRequest addUserCardRequest*/) {
        // Implement addUserCard logic using the userService
    }

    @PostMapping("/user/card/remove")
    public void removeUserCard(/*@RequestBody RemoveUserCardRequest removeUserCardRequest*/) {
        // Implement removeUserCard logic using the userService
    }
}

