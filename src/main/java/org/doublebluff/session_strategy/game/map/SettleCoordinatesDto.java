package org.doublebluff.session_strategy.game.map;

import lombok.Data;

@Data
public class SettleCoordinatesDto {

    private SpotCoordinate leftUp;
    private SpotCoordinate rightUp;
    private SpotCoordinate rightDown;
    private SpotCoordinate leftDown;

}
