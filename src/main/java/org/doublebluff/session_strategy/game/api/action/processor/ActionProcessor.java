package org.doublebluff.session_strategy.game.api.action.processor;

import org.doublebluff.session_strategy.game.api.action.dto.ActionDto;
import org.doublebluff.session_strategy.game.api.player.Player;
import org.doublebluff.session_strategy.game.api.event.EventDto;

import java.util.List;

public interface ActionProcessor {

    List<EventDto> process(Player player, ActionDto actionDto);

}
