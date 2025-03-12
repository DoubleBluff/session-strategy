package org.doublebluff.session_strategy.game.action.processor;

import org.doublebluff.session_strategy.game.action.dto.ActionDto;
import org.doublebluff.session_strategy.game.player.Player;
import org.doublebluff.session_strategy.game.event.EventDto;

import java.util.List;

public interface ActionProcessor {

    List<EventDto> process(Player player, ActionDto actionDto);

}
