package com.cpe.vengaboys.asi.services;

import com.cpe.vengaboys.shared.dto.UserDto;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class UserServiceImpl implements UserService {
    private final WebClient webClient;

    public UserServiceImpl(WebClient.Builder webClientBuilder){
        this.webClient = webClientBuilder.baseUrl("http://user-service").build();
    }

    @Override
    public UserDto getUser(Long userId) {
        return webClient.get()
                .uri("/users/{userId}", userId)
                .retrieve()
                .bodyToMono(UserDto.class)
                .block();
    }

    @Override
    public void setUserMoney(Long userId ,Double amount) {
        webClient.put()
                .uri(("/users/{userId}/money"))
                .bodyValue(amount);
    }
}