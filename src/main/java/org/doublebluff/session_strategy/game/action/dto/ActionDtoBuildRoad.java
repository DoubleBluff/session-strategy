package org.doublebluff.session_strategy.game.action.dto;

import lombok.Data;
import org.doublebluff.session_strategy.game.map.RoadCoordinatesDto;

@Data
public class ActionDtoBuildRoad extends ActionDto {

    private RoadCoordinatesDto roadCoordinatesDto;

}
