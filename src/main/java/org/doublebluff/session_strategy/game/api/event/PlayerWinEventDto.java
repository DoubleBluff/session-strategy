package org.doublebluff.session_strategy.game.api.event;

import lombok.Getter;
import org.doublebluff.session_strategy.game.api.Player;

@Getter
public class PlayerWinEventDto extends EventDto {

    private final Player winner;

    public PlayerWinEventDto(EventType type, Player winner) {
        super(type);
        this.winner = winner;
    }

}
