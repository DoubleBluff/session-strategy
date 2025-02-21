package org.doublebluff.session_strategy.game.api;

import lombok.Data;
import org.doublebluff.session_strategy.lobby.User;

import java.util.List;

@Data
public class Player {

    private User user;

    private PlayerColor color;

    private List<Resource> resources;
}
