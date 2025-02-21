package org.doublebluff.session_strategy.lobby.service;

import lombok.RequiredArgsConstructor;
import org.doublebluff.session_strategy.error.NotFoundApiException;
import org.doublebluff.session_strategy.lobby.LobbyStorage;
import org.doublebluff.session_strategy.lobby.User;
import org.doublebluff.session_strategy.lobby.dto.LobbyDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class LobbyLeaveService {

    private final LobbyStorage lobbyStorage;


    public LobbyDto leave(UUID lobbyId, User user) {
        LobbyDto lobbyDto = lobbyStorage.getById(lobbyId)
                .orElseThrow(NotFoundApiException::new);
        lobbyDto.getUsers().remove(user);
        return lobbyDto;
    }
}
