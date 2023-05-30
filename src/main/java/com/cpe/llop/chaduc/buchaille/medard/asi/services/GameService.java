package com.cpe.llop.chaduc.buchaille.medard.asi.services;

import com.cpe.llop.chaduc.buchaille.medard.asi.models.Card;
import com.cpe.llop.chaduc.buchaille.medard.asi.models.Room;

import java.util.List;

public interface GameService {
    public Room createRoom(Card card);
    public List<Room> getRooms();
    public Room getRoom(String name);
    public Room getRoom(long id);
    public void joinRoom(Card card,String roomName);

}
