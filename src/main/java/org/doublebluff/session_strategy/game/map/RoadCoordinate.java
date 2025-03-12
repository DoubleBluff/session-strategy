package org.doublebluff.session_strategy.game.map;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.Collection;

@Getter
@EqualsAndHashCode
@AllArgsConstructor
public class RoadCoordinate {

    private Collection<SettleCoordinate> settleSpots;

}
