package com.cpe.llop.chaduc.buchaille.medard.asi.repositories;

import com.cpe.llop.chaduc.buchaille.medard.asi.models.Room;
import com.cpe.llop.chaduc.buchaille.medard.asi.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
    Room findByRoomName(String username);
}
