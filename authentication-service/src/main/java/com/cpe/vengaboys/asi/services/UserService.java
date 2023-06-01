package com.cpe.vengaboys.asi.services;

import com.cpe.vengaboys.asi.exception.LoginException;
import com.cpe.vengaboys.asi.exception.RegisterException;
import com.cpe.vengaboys.asi.models.User;
import com.cpe.vengaboys.shared.dto.LoginDto;
import com.cpe.vengaboys.shared.dto.RegisterDto;
import com.cpe.vengaboys.shared.dto.UserDto;

public interface UserService {
    public User addUser(RegisterDto registerDto);
    public User getUser(Long userId);
    public User getUser(String username);
    public User updateUser(Long userId, UserDto userForm);
    public boolean deleteUser(Long userId);
    public Boolean authenticate(String token);
    public String register(RegisterDto userForm) throws RegisterException;
    public String login(LoginDto userForm) throws LoginException;
}
