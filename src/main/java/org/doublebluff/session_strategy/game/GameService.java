package org.doublebluff.session_strategy.game;

import lombok.RequiredArgsConstructor;
import org.doublebluff.session_strategy.error.NotFoundApiException;
import org.doublebluff.session_strategy.game.api.action.ActionDto;
import org.doublebluff.session_strategy.game.api.event.EventDto;
import org.doublebluff.session_strategy.lobby.User;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GameService {

    private final GameStorage gameStorage;

    public void doAction(UUID gameId, ActionDto actionDto, User user) {
        gameStorage.getById(gameId).orElseThrow(NotFoundApiException::new).doAction(user, actionDto);
    }

    public List<EventDto> getNewEvents(UUID gameId, LocalDateTime lastUpdateTime, User user) {
        return gameStorage.getById(gameId).orElseThrow(NotFoundApiException::new).getNewEvents(user, lastUpdateTime);
    }
}
