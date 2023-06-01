package com.cpe.vengaboys.asi.shared.dto;

import java.util.Optional;

public class UserDto {
    public Long id;
    public String username;
    public String email;
    public Double money;

    public UserDto() {}

    public UserDto(Long id, String username, String email, Double money) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.money = money;
    }
}
