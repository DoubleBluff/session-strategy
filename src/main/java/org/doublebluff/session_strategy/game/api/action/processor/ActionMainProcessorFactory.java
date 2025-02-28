package org.doublebluff.session_strategy.game.api.action.processor;

import org.doublebluff.session_strategy.game.api.GameInnerApi;
import org.doublebluff.session_strategy.game.api.action.ActionType;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class ActionMainProcessorFactory {

    public ActionMainProcessor get(GameInnerApi game) {
        return new ActionMainProcessor(Map.of(
                ActionType.BUILD_ROAD, new ActionProcessorBuildRoad(game),
                ActionType.BUILD_SETTLE, new ActionProcessorBuildSettle(game),
                ActionType.END_MOVE, new ActionProcessorEndMove(game)
        ));
    }
}
