package com.cpe.llop.chaduc.buchaille.medard.asi.services;

import com.cpe.llop.chaduc.buchaille.medard.asi.models.User;
import org.springframework.data.domain.Page;

import java.util.List;

public interface UserService {
    public User getUser(Long userId);
    public Page<User> getUsers(Integer page, Integer size);
    public List<User> getUsers();
    public User getUser(String username);
    public void addUserMoney(Long username, Double amount);
    public User addUser(String username, String password, String email);
    public User login(String username, String password);
}
