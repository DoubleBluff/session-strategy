package org.doublebluff.session_strategy.lobby.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.doublebluff.session_strategy.lobby.User;

import java.util.List;
import java.util.UUID;

@Data
public class LobbyDto {

    /*
    READ ONLY
     */
    private UUID id;

    @NotEmpty
    private String name;

    /**
     * Пользователи в лобби
     * READ ONLY
     */
    private List<User> users;
}
