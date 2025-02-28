package org.doublebluff.session_strategy.game;

import lombok.RequiredArgsConstructor;
import org.doublebluff.session_strategy.game.api.action.dto.ActionDto;
import org.doublebluff.session_strategy.game.api.event.EventDto;
import org.doublebluff.session_strategy.lobby.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/games")
public class GameController {

    private final GameService gameService;


    @PostMapping("/v1/{gameId}/actions")
    public void doAction(@PathVariable UUID gameId, @RequestBody ActionDto actionDto, @RequestParam UUID userId, @RequestParam String username) {
        gameService.doAction(gameId, actionDto, new User(userId, username));
    }

    @GetMapping("/v1/{gameId}/events")
    public List<EventDto> getNewEvents(@PathVariable UUID gameId, @RequestParam UUID userId, @RequestParam String username) {
        return gameService.getNewEvents(gameId, new User(userId, username));
    }
}
