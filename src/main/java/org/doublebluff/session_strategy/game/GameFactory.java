package org.doublebluff.session_strategy.game;

import lombok.RequiredArgsConstructor;
import org.doublebluff.session_strategy.game.action.processor.ActionMainProcessorFactory;
import org.doublebluff.session_strategy.game.map.MapFactory;
import org.doublebluff.session_strategy.game.player.PlayerFactory;
import org.doublebluff.session_strategy.game.resource.ResourceGeneratorFactory;
import org.doublebluff.session_strategy.lobby.User;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
@RequiredArgsConstructor
public class GameFactory {

    private final EndGameChecker endGameChecker;

    private final ActionMainProcessorFactory actionMainProcessorFactory;

    private final MapFactory mapFactory;

    private final PlayerFactory playerFactory;

    private final ResourceGeneratorFactory resourceGeneratorFactory;

    public GameApi get(Collection<User> users) {
        return new GameImpl(endGameChecker,
                actionMainProcessorFactory,
                resourceGeneratorFactory,
                mapFactory.getDefault(),
                playerFactory.get(users));
    }

}
