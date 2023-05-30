package com.cpe.llop.chaduc.buchaille.medard.asi.dto;

public class RegisterDto {
    private String username;
    private String password;
    private String email;

    public RegisterDto() {}

    public RegisterDto(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }
}
