package org.doublebluff.session_strategy.game.event;

import org.doublebluff.session_strategy.game.resource.ResourceType;
import org.doublebluff.session_strategy.game.map.RoadCoordinatesDto;
import org.doublebluff.session_strategy.game.map.SettleCoordinatesDto;
import org.doublebluff.session_strategy.game.player.Player;

import java.util.Collection;

public class EventFactory {

    public EventDto nextMove(Player player) {
        return new NextMoveEventDto(player.getUser().getId());
    }

    public EventDto newRoad(Player player, RoadCoordinatesDto roadCoordinatesDto) {
        return new NewRoadEventDto(player.getUser().getId(), roadCoordinatesDto);
    }

    public EventDto newSettle(Player player, SettleCoordinatesDto settleCoordinatesDto) {
        return new NewSettleEventDto(player.getUser().getId(), settleCoordinatesDto);
    }

    public EventDto playerWon(Player player) {
        return new PlayerWonEventDto(player.getUser().getId());
    }

    public EventDto newResources(Collection<ResourceType> resources) {
        return new NewResourcesEventDto(resources);
    }

    public EventDto resourcesSpent(Player player, Collection<ResourceType> resources) {
        return new ResourcesSpentEventDto(player.getUser().getId(), resources);
    }
}
