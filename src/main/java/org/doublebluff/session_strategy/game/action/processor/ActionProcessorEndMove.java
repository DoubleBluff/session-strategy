package org.doublebluff.session_strategy.game.action.processor;

import lombok.RequiredArgsConstructor;
import org.doublebluff.session_strategy.game.GameInnerApi;
import org.doublebluff.session_strategy.game.action.dto.ActionDto;
import org.doublebluff.session_strategy.game.event.EventDto;
import org.doublebluff.session_strategy.game.player.Player;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
class ActionProcessorEndMove implements ActionProcessor {

    private final GameInnerApi gameInnerApi;

    @Override
    public List<EventDto> process(Player player, ActionDto actionDto) {
        List<EventDto> events = new ArrayList<>(gameInnerApi.doOnMoveEndActions());
        events.add(gameInnerApi.getEventFactory().nextMove(gameInnerApi.getPlayerOrderSwitcher().switchPlayer()));
        return events;
    }
}
