package org.doublebluff.session_strategy.game.map;

import org.doublebluff.session_strategy.game.api.player.Player;

public interface MapInnerApi {


    boolean canBuildRoad(Player player, RoadCoordinatesDto roadCoordinatesDto);

    boolean canBuildSettle(Player player, SettleCoordinatesDto settleCoordinatesDto);
}
