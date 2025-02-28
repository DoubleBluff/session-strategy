package org.doublebluff.session_strategy.game.api;

import org.doublebluff.session_strategy.game.api.event.EventFactory;
import org.doublebluff.session_strategy.game.api.player.PlayerOrderSwitcher;
import org.doublebluff.session_strategy.game.map.MapInnerApi;

public interface GameInnerApi {

    EventFactory getEventFactory();

    PlayerOrderSwitcher getPlayerOrderSwitcher();

    MapInnerApi getMapInnerApi();

}
