package org.doublebluff.session_strategy.lobby.service;

import lombok.RequiredArgsConstructor;
import org.doublebluff.session_strategy.error.NotFoundApiException;
import org.doublebluff.session_strategy.game.GameDto;
import org.doublebluff.session_strategy.lobby.LobbyStorage;
import org.doublebluff.session_strategy.lobby.dto.LobbyDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class LobbyStartService {

    private final LobbyStorage lobbyStorage;

    public GameDto start(UUID lobbyId) {
        LobbyDto lobbyDto = lobbyStorage.getById(lobbyId)
                .orElseThrow(NotFoundApiException::new);




        return null;
    }
}
