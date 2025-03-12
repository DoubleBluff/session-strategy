package org.doublebluff.session_strategy.game;

import org.doublebluff.session_strategy.game.event.EventDto;
import org.doublebluff.session_strategy.game.event.EventFactory;
import org.doublebluff.session_strategy.game.player.Player;
import org.doublebluff.session_strategy.game.player.PlayerOrderSwitcher;
import org.doublebluff.session_strategy.game.map.MapInnerApi;

import java.util.List;

public interface GameInnerApi {

    List<Player> getPlayers();

    EventFactory getEventFactory();

    PlayerOrderSwitcher getPlayerOrderSwitcher();

    MapInnerApi getMapInnerApi();

    List<EventDto> doOnMoveEndActions();
}
