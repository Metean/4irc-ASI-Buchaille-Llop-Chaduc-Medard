package com.cpe.llop.chaduc.buchaille.medard.asi.controllers;


import com.cpe.llop.chaduc.buchaille.medard.asi.models.Room;
import com.cpe.llop.chaduc.buchaille.medard.asi.services.GameService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/game")
public class GameController {

    private GameService gameService;

    public GameController() {
        super();
    }

    public GameController(GameService gameService) {
        setGameService(gameService);
    }

    private void setGameService(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping("/")
    public List<Room> getAllRooms() {
        return gameService.getRooms();
    }

    @GetMapping("/name/{name}")
    public Room getRoom(@PathVariable("name") String name) {
        return gameService.getRoom(name);
    }

    @GetMapping("/{id}")
    public Room getRoom(@PathVariable("id") Long id) {
        return gameService.getRoom(id);
    }
}
