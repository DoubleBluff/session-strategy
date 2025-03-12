package org.doublebluff.session_strategy.game;

import org.doublebluff.session_strategy.game.action.dto.ActionDto;
import org.doublebluff.session_strategy.game.event.EventDto;
import org.doublebluff.session_strategy.lobby.User;

import java.util.List;


public interface GameApi {

    void doAction(User user, ActionDto actionDto);


    List<EventDto> getNewEvents(User user);
}
