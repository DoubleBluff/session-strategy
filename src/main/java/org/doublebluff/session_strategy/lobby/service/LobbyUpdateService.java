package org.doublebluff.session_strategy.lobby.service;

import lombok.RequiredArgsConstructor;
import org.doublebluff.session_strategy.error.NotFoundApiException;
import org.doublebluff.session_strategy.lobby.LobbyStorage;
import org.doublebluff.session_strategy.lobby.dto.LobbyDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class LobbyUpdateService {

    private final LobbyStorage lobbyStorage;

    public LobbyDto update(UUID lobbyId, LobbyDto lobbyDto) {
        LobbyDto existedLobbyDto = lobbyStorage.getById(lobbyId)
                .orElseThrow(NotFoundApiException::new);
        existedLobbyDto.setName(lobbyDto.getName());
        return existedLobbyDto;
    }
}
