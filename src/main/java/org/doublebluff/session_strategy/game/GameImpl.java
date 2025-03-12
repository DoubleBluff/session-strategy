package org.doublebluff.session_strategy.game;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.doublebluff.session_strategy.error.BadRequestApiException;
import org.doublebluff.session_strategy.game.action.dto.ActionDto;
import org.doublebluff.session_strategy.game.action.processor.ActionMainProcessor;
import org.doublebluff.session_strategy.game.action.processor.ActionMainProcessorFactory;
import org.doublebluff.session_strategy.game.event.EventDto;
import org.doublebluff.session_strategy.game.event.EventFactory;
import org.doublebluff.session_strategy.game.map.MapInnerApi;
import org.doublebluff.session_strategy.game.player.Player;
import org.doublebluff.session_strategy.game.player.PlayerOrderSwitcher;
import org.doublebluff.session_strategy.game.resource.ResourceGenerator;
import org.doublebluff.session_strategy.game.resource.ResourceGeneratorFactory;
import org.doublebluff.session_strategy.lobby.User;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class GameImpl implements GameApi, GameInnerApi {

    private final EndGameChecker endGameChecker;

    private final ActionMainProcessor actionMainProcessor;

    private final EventStorage eventStorage;

    private final Map<UUID, Player> playersByUserId;

    private final ResourceGenerator resourceGenerator;

    @Getter
    private final PlayerOrderSwitcher playerOrderSwitcher;

    @Getter
    private final EventFactory eventFactory;

    @Getter
    private final MapInnerApi mapInnerApi;

    public GameImpl(EndGameChecker endGameChecker,
                    ActionMainProcessorFactory actionMainProcessorFactory,
                    ResourceGeneratorFactory resourceGeneratorFactory,
                    MapInnerApi mapInnerApi,
                    List<Player> players) {
        this.endGameChecker = endGameChecker;
        this.actionMainProcessor = actionMainProcessorFactory.get(this);
        this.eventStorage = new EventStorage(players);
        playersByUserId = players.stream().collect(Collectors.toMap(player -> player.getUser().getId(), Function.identity()));
        this.resourceGenerator = resourceGeneratorFactory.get(this);
        this.playerOrderSwitcher = new PlayerOrderSwitcher(players);
        this.eventFactory = new EventFactory();
        this.mapInnerApi = mapInnerApi;
    }

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

    @Override
    public List<Player> getPlayers() {
        return new ArrayList<>(playersByUserId.values());
    }

    @Override
    public List<EventDto> doOnMoveEndActions() {
        List<EventDto> r = new ArrayList<>();
        endGameChecker.getWinner(playersByUserId.values())
                .map(eventFactory::playerWon)
                .ifPresent(r::add);
        r.addAll(resourceGenerator.generate(playerOrderSwitcher.getRound()));
        return r;
    }
}
