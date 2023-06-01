package com.cpe.vengaboys.shared.dto;

public class RegisterDto {
    public String username;
    public String password;
    public String email;

    public RegisterDto() {}

    public RegisterDto(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }
}
