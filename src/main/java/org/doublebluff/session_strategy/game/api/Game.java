package org.doublebluff.session_strategy.game.api;

import org.doublebluff.session_strategy.game.api.action.ActionDto;
import org.doublebluff.session_strategy.game.api.event.EventDto;
import org.doublebluff.session_strategy.lobby.User;

import java.time.LocalDateTime;
import java.util.List;

public interface Game {

    void doAction(User user, ActionDto actionDto);


    List<EventDto> getNewEvents(User user, LocalDateTime lastUpdateTime);
}
