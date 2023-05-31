package com.cpe.vengaboys.asi.shared.dto;

public class UserDto {
    private Long id;
    private String username;
    private String email;
    private Double money;

    public UserDto() {}

    public UserDto(Long id, String username, String email, Double money) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.money = money;
    }
}