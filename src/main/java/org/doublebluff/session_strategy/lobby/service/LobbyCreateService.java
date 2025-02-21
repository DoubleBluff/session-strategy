package org.doublebluff.session_strategy.lobby.service;

import lombok.RequiredArgsConstructor;
import org.doublebluff.session_strategy.lobby.LobbyStorage;
import org.doublebluff.session_strategy.lobby.User;
import org.doublebluff.session_strategy.lobby.dto.LobbyDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
@RequiredArgsConstructor
public class LobbyCreateService {

    private final LobbyStorage lobbyStorage;

    public LobbyDto create(LobbyDto lobbyDto, User user) {
        lobbyDto.setId(UUID.randomUUID());

        List<User> users = new CopyOnWriteArrayList<>();
        users.add(user);

        lobbyDto.setUsers(users);
        lobbyStorage.create(lobbyDto);
        return lobbyDto;
    }
}
