package org.doublebluff.session_strategy.lobby;

import org.doublebluff.session_strategy.lobby.dto.LobbyDto;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class LobbyStorage {

    private final Map<UUID, LobbyDto> lobbiesById;

    public LobbyStorage() {
        lobbiesById = new ConcurrentHashMap<>();
    }

    public List<LobbyDto> getAll() {
        return new ArrayList<>(lobbiesById.values());
    }

    public Optional<LobbyDto> getById(UUID lobbyId) {
        return Optional.ofNullable(lobbiesById.get(lobbyId));
    }

    public LobbyDto create(LobbyDto lobbyDto) {
        lobbiesById.put(lobbyDto.getId(), lobbyDto);
        return lobbyDto;
    }
}
