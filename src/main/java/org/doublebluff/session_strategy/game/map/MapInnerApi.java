package org.doublebluff.session_strategy.game.map;

import org.doublebluff.session_strategy.game.player.Player;

import java.util.List;

public interface MapInnerApi {

    void buildRoad(Player player, RoadCoordinatesDto roadCoordinatesDto);

    void buildSettle(Player player, SettleCoordinatesDto settleCoordinatesDto);

    List<SpotType> getSpotsAround(SettleCoordinatesDto settleCoordinatesDto);
}
