package org.doublebluff.session_strategy.game;

import org.doublebluff.session_strategy.game.api.Game;
import org.doublebluff.session_strategy.lobby.dto.LobbyDto;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class GameStorage {

    private final Map<UUID, Game> gamesById;

    public GameStorage() {
        gamesById = new ConcurrentHashMap<>();
    }

    public void create(LobbyDto lobbyDto) {

    }

    public Optional<Game> getById(UUID gameId) {
        return Optional.ofNullable(gamesById.get(gameId));
    }
}
