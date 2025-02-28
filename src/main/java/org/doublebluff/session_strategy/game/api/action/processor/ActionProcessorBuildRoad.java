package org.doublebluff.session_strategy.game.api.action.processor;

import lombok.RequiredArgsConstructor;
import org.doublebluff.session_strategy.error.BadRequestApiException;
import org.doublebluff.session_strategy.game.api.GameInnerApi;
import org.doublebluff.session_strategy.game.api.ResourceType;
import org.doublebluff.session_strategy.game.api.action.dto.ActionDto;
import org.doublebluff.session_strategy.game.api.action.dto.ActionDtoBuildRoad;
import org.doublebluff.session_strategy.game.api.event.EventDto;
import org.doublebluff.session_strategy.game.api.player.Player;

import java.util.List;

@RequiredArgsConstructor
class ActionProcessorBuildRoad implements ActionProcessor {

    private static final List<ResourceType> PRICE = List.of(
            ResourceType.WOOD,
            ResourceType.ROCK,
            ResourceType.FOOD
    );

    private final GameInnerApi gameInnerApi;

    @Override
    public List<EventDto> process(Player player, ActionDto actionDto) {
        if (actionDto instanceof ActionDtoBuildRoad actionDtoBuildRoad) {
            if (!player.areResourcesEnough(PRICE)) {
                throw new BadRequestApiException("NOT ENOUGH RESOURCES");
            }

            if (!gameInnerApi.getMapInnerApi().canBuildRoad(player, actionDtoBuildRoad.getRoadCoordinatesDto())) {
                throw new BadRequestApiException("CANNOT BUILD ROAD");
            }

            player.spentResources(PRICE);
            return List.of(
                    gameInnerApi.getEventFactory().resourcesSpent(player, PRICE),
                    gameInnerApi.getEventFactory().newRoad(player, actionDtoBuildRoad.getRoadCoordinatesDto())
            );

        }
        throw new RuntimeException("INCORRECT TYPE OF ACTION: " + actionDto.getClass().getName());
    }
}
