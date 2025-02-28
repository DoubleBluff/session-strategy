package org.doublebluff.session_strategy.game.api;

import lombok.RequiredArgsConstructor;
import org.doublebluff.session_strategy.game.api.action.processor.ActionMainProcessorFactory;
import org.doublebluff.session_strategy.game.api.player.PlayerFactory;
import org.doublebluff.session_strategy.game.map.MapFactory;
import org.doublebluff.session_strategy.lobby.User;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
@RequiredArgsConstructor
public class GameFactory {

    private final ActionMainProcessorFactory actionMainProcessorFactory;

    private final MapFactory mapFactory;

    private final PlayerFactory playerFactory;

    public GameApi get(Collection<User> users) {
        return new GameImpl(actionMainProcessorFactory, mapFactory.get(), playerFactory.get(users));
    }

}
