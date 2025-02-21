package org.doublebluff.session_strategy.lobby.service;

import lombok.RequiredArgsConstructor;
import org.doublebluff.session_strategy.error.NotFoundApiException;
import org.doublebluff.session_strategy.lobby.LobbyStorage;
import org.doublebluff.session_strategy.lobby.dto.LobbyDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class LobbyGetService {

    private final LobbyStorage lobbyStorage;

    public LobbyDto getById(UUID lobbyId) {
        return lobbyStorage.getById(lobbyId)
                .orElseThrow(NotFoundApiException::new);
    }

    public List<LobbyDto> getAll() {
        return lobbyStorage.getAll();
    }
}
