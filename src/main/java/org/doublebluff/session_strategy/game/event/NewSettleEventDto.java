package org.doublebluff.session_strategy.game.event;

import lombok.Getter;
import org.doublebluff.session_strategy.game.map.SettleCoordinatesDto;

import java.util.UUID;

@Getter
public class NewSettleEventDto extends EventDto {

    private final UUID userId;

    private final SettleCoordinatesDto settleCoordinatesDto;

    public NewSettleEventDto(UUID userId, SettleCoordinatesDto settleCoordinatesDto) {
        super(EventType.NEW_SETTLE);
        this.userId = userId;
        this.settleCoordinatesDto = settleCoordinatesDto;
    }
}
