package org.doublebluff.session_strategy.game.resource;

import lombok.AllArgsConstructor;
import org.doublebluff.session_strategy.game.GameInnerApi;
import org.doublebluff.session_strategy.game.event.EventDto;
import org.doublebluff.session_strategy.game.map.SpotType;
import org.doublebluff.session_strategy.game.player.Player;
import org.doublebluff.session_strategy.game.player.Settle;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

/**
 * Выдает ресурсы в конце раунда
 */
@AllArgsConstructor
public class ResourceGenerator {

    private final GameInnerApi gameInnerApi;

    private int lastProcessedRound;

    public List<EventDto> generate(int round) {
        if (lastProcessedRound != round) {
            lastProcessedRound = round;
            return generate();
        }
        return List.of();
    }

    private List<EventDto> generate() {
        List<Player> players = gameInnerApi.getPlayers();
        List<EventDto> events = new ArrayList<>();
        for (Player player : players) {
            List<Settle> settles = player.getSettles();

            List<ResourceType> resources = settles.stream()
                    .map(Settle::getCoordinates)
                    .map(c -> gameInnerApi.getMapInnerApi().getSpotsAround(c))
                    .flatMap(Collection::stream)
                    .map(this::getResourceForSpot)
                    .filter(Objects::nonNull)
                    .toList();
            player.getResources().addAll(resources);
            events.add(gameInnerApi.getEventFactory().newResources(resources));
        }
        return events;
    }

    private ResourceType getResourceForSpot(SpotType spotType) {
        return switch (spotType) {
            case FIELD -> ResourceType.FOOD;
            case FOREST -> ResourceType.WOOD;
            case MOUNTAINS -> ResourceType.ROCK;
            case SEA -> null;
        };
    }
}
