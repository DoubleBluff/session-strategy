package org.doublebluff.session_strategy.game.api.action.processor;

import lombok.RequiredArgsConstructor;
import org.doublebluff.session_strategy.game.api.GameInnerApi;
import org.doublebluff.session_strategy.game.api.action.dto.ActionDto;
import org.doublebluff.session_strategy.game.api.event.EventDto;
import org.doublebluff.session_strategy.game.api.player.Player;

import java.util.List;

@RequiredArgsConstructor
class ActionProcessorEndMove implements ActionProcessor {

    private final GameInnerApi gameInnerApi;

    @Override
    public List<EventDto> process(Player player, ActionDto actionDto) {
        return List.of(gameInnerApi.getEventFactory().nextMove(gameInnerApi.getPlayerOrderSwitcher().switchPlayer()));
    }
}
