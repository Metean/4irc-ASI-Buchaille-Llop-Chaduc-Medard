package com.cpe.vengaboys.asi.services;

import com.cpe.vengaboys.asi.exception.LoginException;
import com.cpe.vengaboys.asi.exception.RegisterException;
import com.cpe.vengaboys.asi.models.User;
import com.cpe.vengaboys.asi.repositories.UserRepository;
import com.cpe.vengaboys.asi.shared.dto.LoginDto;
import com.cpe.vengaboys.asi.shared.dto.RegisterDto;
import com.cpe.vengaboys.asi.shared.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User addUser(RegisterDto registerDto) {
        User u = new User(registerDto.username, registerDto.password, registerDto.email);
        userRepository.save(u);
        return u;
    }

    public User getUser(Long userId) {
        Optional<User> u = userRepository.findById(userId);
        return u.orElse(null);
    }

    public User getUser(String username) {
        Optional<User> u = userRepository.findByUsername(username);
        return u.orElse(null);
    }

    public User updateUser(Long userId, UserDto userForm) {
        User user = this.getUser(userId);
        user.setUsername(userForm.username);
        // user.setPassword(userForm.password);
        user.setEmail(userForm.email);
        return userRepository.save(user);
    }

    public boolean deleteUser(Long userId) {
        userRepository.deleteById(userId);
        return this.getUser(userId) == null;
    }

    public Boolean authenticate(String token) {
        User user = this.getUser(token);
        return user != null;
    }

    private String generateToken(User user) {
        user.generateToken();
        userRepository.save(user);
        return user.getToken();
    }

    @Override
    public String register(RegisterDto userForm) throws RegisterException {
        if (this.getUser(userForm.username) != null) {
            throw new RegisterException();
        }

        User user = this.addUser(userForm);
        return this.generateToken(user);
    }

    @Override
    public String login(LoginDto userForm) throws LoginException {
        User user = this.getUser(userForm.username);
        if (user == null) {
            throw new LoginException();
        }
        if (user.getPassword().equals(userForm.password)) {
            return this.generateToken(user);
        }
        throw new LoginException();
    }
}