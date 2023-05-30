package com.cpe.llop.chaduc.buchaille.medard.asi.services;

import com.cpe.llop.chaduc.buchaille.medard.asi.models.Card;
import com.cpe.llop.chaduc.buchaille.medard.asi.models.Room;
import com.cpe.llop.chaduc.buchaille.medard.asi.repositories.CardRepository;
import com.cpe.llop.chaduc.buchaille.medard.asi.repositories.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class GameServiceImpl implements GameService {

    private final Random randomGenerator;
    private final CardRepository cardRepository;
    private final RoomRepository roomRepository;

    public GameServiceImpl(CardRepository cardRepository, RoomRepository roomRepository) {
        randomGenerator = new Random();
        this.cardRepository = cardRepository;
        this.roomRepository = roomRepository;
    }

    public List<Card> getCardList() {
        return this.cardRepository.findAll();
    }


    @Override
    public Room createRoom(Card card) {
        Room r = new Room(card);
        roomRepository.save(r);
        return r;
    }

    @Override
    public List<Room> getRooms() {
        return roomRepository.findAll();
    }

    @Override
    public Room getRoom(String name) {
        return roomRepository.findByRoomName(name);
    }

    @Override
    public Room getRoom(long id) {
        return roomRepository.getReferenceById(id);
    }

    @Override
    public void joinRoom(Card card, String roomName) {
        Room r = roomRepository.findByRoomName(roomName);

        if (r != null) {
            r.setCard2(card);
        }
    }
}
