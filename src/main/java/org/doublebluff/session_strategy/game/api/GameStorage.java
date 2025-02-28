package org.doublebluff.session_strategy.game.api;

import lombok.RequiredArgsConstructor;
import org.doublebluff.session_strategy.lobby.dto.LobbyDto;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Component
@RequiredArgsConstructor
public class GameStorage {

    private final GameFactory gameFactory;

    private final Map<UUID, GameApi> gamesByLobbyId = new ConcurrentHashMap<>();

    public Optional<GameApi> getByLobbyId(UUID lobbyId) {
        return Optional.ofNullable(gamesByLobbyId.get(lobbyId));
    }

    public GameApi start(LobbyDto lobbyDto) {
        GameApi gameApi = gameFactory.get(lobbyDto.getUsers());
        gamesByLobbyId.put(lobbyDto.getId(), gameApi);
        return gameApi;
    }

    public GameApi finish(UUID gameId) {
        return gamesByLobbyId.remove(gameId);
    }
}
