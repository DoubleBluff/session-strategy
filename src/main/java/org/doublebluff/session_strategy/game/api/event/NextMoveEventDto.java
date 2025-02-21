package org.doublebluff.session_strategy.game.api.event;

import lombok.Getter;
import org.doublebluff.session_strategy.game.api.Player;

@Getter
public class NextMoveEventDto extends EventDto {

    private final Player nextPlayer;

    public NextMoveEventDto(EventType type, Player nextPlayer) {
        super(type);
        this.nextPlayer = nextPlayer;
    }

}
