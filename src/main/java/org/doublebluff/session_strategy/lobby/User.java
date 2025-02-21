package org.doublebluff.session_strategy.lobby;

import lombok.Data;

import java.util.UUID;

@Data
public class User {

    private UUID id;

    private String username;

    public User(UUID id, String username) {
        this.id = id;
        this.username = username;
    }
}
