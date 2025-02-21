package org.doublebluff.session_strategy.game;

import lombok.Data;
import org.doublebluff.session_strategy.game.api.Player;

import java.util.List;
import java.util.UUID;

@Data
public class GameDto {

    private UUID id;

    private List<Player> players;

}
