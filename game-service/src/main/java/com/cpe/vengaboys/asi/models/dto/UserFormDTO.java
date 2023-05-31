package com.cpe.vengaboys.asi.models.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

public class UserFormDTO {
    private String username;
    private String password;
    private String email;
    private Double money;

    public UserFormDTO() {}
    public UserFormDTO(String username, String password, String email) {
        this.username = username;
        this.password=password;
        this.email=email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }
}
