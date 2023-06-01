package com.cpe.vengaboys.asi.shared.dto;

public class LoginDto {
    public String username;
    public String password;

    public LoginDto() {}

    public LoginDto(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
