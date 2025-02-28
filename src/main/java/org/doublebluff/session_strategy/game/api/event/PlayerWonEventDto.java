package org.doublebluff.session_strategy.game.api.event;

import lombok.Getter;

import java.util.UUID;

@Getter
public class PlayerWonEventDto extends EventDto {

    private final UUID userId;

    public PlayerWonEventDto(UUID userId) {
        super(EventType.PLAYER_WON);
        this.userId = userId;
    }

}
