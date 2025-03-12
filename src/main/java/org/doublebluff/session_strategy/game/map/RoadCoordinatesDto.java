package org.doublebluff.session_strategy.game.map;

import lombok.Data;

import java.util.Collection;

@Data
public class RoadCoordinatesDto {

    private Collection<SettleCoordinatesDto> settleSpotsCoordinates;
}
