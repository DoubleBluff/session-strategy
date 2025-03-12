package org.doublebluff.session_strategy.game.map;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

import java.util.List;



@EqualsAndHashCode
@AllArgsConstructor
public class SettleCoordinate {

    private SpotCoordinate leftUp;
    private SpotCoordinate rightUp;
    private SpotCoordinate rightDown;
    private SpotCoordinate leftDown;

    public List<SpotCoordinate> getSpotsCoordinatesAround() {
        return List.of(leftUp, rightUp, rightDown, leftDown);
    }
}
