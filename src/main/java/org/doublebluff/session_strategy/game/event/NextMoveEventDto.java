package org.doublebluff.session_strategy.game.event;

import lombok.Getter;

import java.util.UUID;

@Getter
public class NextMoveEventDto extends EventDto {

    private final UUID userId;

    public NextMoveEventDto(UUID userId) {
        super(EventType.NEXT_MOVE);
        this.userId = userId;
    }

}
