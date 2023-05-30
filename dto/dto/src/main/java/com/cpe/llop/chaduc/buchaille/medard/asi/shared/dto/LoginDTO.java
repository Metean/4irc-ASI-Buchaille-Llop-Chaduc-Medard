package com.cpe.llop.chaduc.buchaille.medard.asi.dto;

public class LoginDto {
    private String username;
    private String password;

    public LoginDto() {}

    public LoginDto(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
