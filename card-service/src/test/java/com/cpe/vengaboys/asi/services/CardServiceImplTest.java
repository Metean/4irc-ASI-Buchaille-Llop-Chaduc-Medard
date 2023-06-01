package com.cpe.vengaboys.asi.services;

import com.cpe.vengaboys.asi.models.Card;
import com.cpe.vengaboys.asi.models.User;
import com.cpe.vengaboys.asi.repositories.CardRepository;
import com.cpe.vengaboys.asi.shared.dto.CardDto;
import com.cpe.vengaboys.asi.shared.service.MapperService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CardServiceImplTest {

    private CardRepository cardRepositoryMock;
    private UserService userServiceMock;
    private MapperService mapperServiceMock;

    private CardServiceImpl cardService;

    @BeforeEach
    void setUp() {
        cardRepositoryMock = Mockito.mock(CardRepository.class);
        userServiceMock = Mockito.mock(UserService.class);
        mapperServiceMock = Mockito.mock(MapperService.class);

        cardService = new CardServiceImpl(cardRepositoryMock, userServiceMock, mapperServiceMock);
    }

    @Test
    void shouldGetAvailableCards() {
        // Arrange
        Card cardMock = Mockito.mock(Card.class);
        List<Card> cardsMock = Arrays.asList(cardMock);
        when(cardRepositoryMock.findByUserIsNull()).thenReturn(cardsMock);

        CardDto cardDtoMock = new CardDto();

        // Act
        List<CardDto> result = cardService.GetAvailableCards();

        // Assert
        assertEquals(cardsMock.size(), result.size());
        verify(cardRepositoryMock, times(1)).findByUserIsNull();
        verify(mapperServiceMock, times(1)).map(any(Card.class), any(CardDto.class));
    }
}
