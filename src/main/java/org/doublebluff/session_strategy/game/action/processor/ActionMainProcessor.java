package org.doublebluff.session_strategy.game.action.processor;

import lombok.RequiredArgsConstructor;
import org.doublebluff.session_strategy.game.action.ActionType;
import org.doublebluff.session_strategy.game.action.dto.ActionDto;
import org.doublebluff.session_strategy.game.event.EventDto;
import org.doublebluff.session_strategy.game.player.Player;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
public class ActionMainProcessor {

    private final Map<ActionType, ActionProcessor> actionProcessorsByType;

    public List<EventDto> process(Player player, ActionDto actionDto) {
        return actionProcessorsByType.get(actionDto.getType()).process(player, actionDto);
    }
}
