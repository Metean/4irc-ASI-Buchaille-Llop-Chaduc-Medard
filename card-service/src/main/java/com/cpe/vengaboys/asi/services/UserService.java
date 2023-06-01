package com.cpe.vengaboys.asi.services;

import com.cpe.vengaboys.asi.models.User;
import org.springframework.web.bind.annotation.RequestParam;
import com.cpe.vengaboys.asi.shared.dto.*;
import reactor.core.publisher.Mono;

public interface UserService {
    public UserDto getUser(Long userId);
    public void setUserMoney(Long userId, Double amount);
}
