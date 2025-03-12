package org.doublebluff.session_strategy.game.event;

import lombok.Getter;
import org.doublebluff.session_strategy.game.map.RoadCoordinatesDto;

import java.util.UUID;

@Getter
public class NewRoadEventDto extends EventDto {

    private final UUID userId;

    private final RoadCoordinatesDto roadCoordinatesDto;

    public NewRoadEventDto(UUID userId, RoadCoordinatesDto roadCoordinatesDto) {
        super(EventType.NEW_ROAD);
        this.userId = userId;
        this.roadCoordinatesDto = roadCoordinatesDto;
    }
}
