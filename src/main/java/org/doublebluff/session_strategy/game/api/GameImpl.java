package org.doublebluff.session_strategy.game.api;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.doublebluff.session_strategy.error.BadRequestApiException;
import org.doublebluff.session_strategy.game.api.action.dto.ActionDto;
import org.doublebluff.session_strategy.game.api.action.processor.ActionMainProcessor;
import org.doublebluff.session_strategy.game.api.action.processor.ActionMainProcessorFactory;
import org.doublebluff.session_strategy.game.api.event.EventDto;
import org.doublebluff.session_strategy.game.api.event.EventFactory;
import org.doublebluff.session_strategy.game.api.player.Player;
import org.doublebluff.session_strategy.game.api.player.PlayerOrderSwitcher;
import org.doublebluff.session_strategy.game.map.MapInnerApi;
import org.doublebluff.session_strategy.lobby.User;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class GameImpl implements GameApi, GameInnerApi {

    private final ActionMainProcessor actionMainProcessor;

    private final EventStorage eventStorage;

    private final Map<UUID, Player> playersByUserId;

    @Getter
    private final PlayerOrderSwitcher playerOrderSwitcher;

    @Getter
    private final EventFactory eventFactory;

    @Getter
    private final MapInnerApi mapInnerApi;

    public GameImpl(ActionMainProcessorFactory actionMainProcessorFactory, MapInnerApi mapInnerApi, List<Player> players) {
        this.actionMainProcessor = actionMainProcessorFactory.get(this);
        this.eventStorage = new EventStorage(players);
        playersByUserId = players.stream().collect(Collectors.toMap(player -> player.getUser().getId(), Function.identity()));
        this.playerOrderSwitcher = new PlayerOrderSwitcher(players);
        this.eventFactory = new EventFactory();
        this.mapInnerApi = mapInnerApi;
    }

    // winner check after each move
    // new resources spending after each move
    @Override
    public void doAction(User user, ActionDto actionDto) {
        Player player = playersByUserId.get(user.getId());
        if (player == null) {
            throw new BadRequestApiException("WRONG GAME ID");
        }
        if (!playerOrderSwitcher.isActivePlayer(player)) {
            throw new BadRequestApiException("NOT ACTIVE PLAYER");
        }

        eventStorage.pushEvents(player, actionMainProcessor.process(player, actionDto));
    }

    @Override
    public List<EventDto> getNewEvents(User user) {
        Player player = playersByUserId.get(user.getId());
        if (player == null) {
            throw new BadRequestApiException("WRONG GAME ID");
        }
        return eventStorage.getNewEvents(player);
    }
}
