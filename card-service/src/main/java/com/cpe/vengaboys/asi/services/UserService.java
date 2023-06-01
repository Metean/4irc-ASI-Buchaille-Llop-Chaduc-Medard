package com.cpe.vengaboys.asi.services;


import com.cpe.vengaboys.asi.shared.dto.UserDto;

public interface UserService {
    public UserDto getUser(Long userId);
    public void setUserMoney(Long userId, Double amount);
}
