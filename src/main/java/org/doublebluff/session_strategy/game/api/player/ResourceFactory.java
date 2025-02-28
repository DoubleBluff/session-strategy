package org.doublebluff.session_strategy.game.api.player;

import lombok.RequiredArgsConstructor;
import org.doublebluff.session_strategy.game.api.ResourceType;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ResourceFactory {

    public List<ResourceType> getDefault() {
        return List.of(
                ResourceType.FOOD,
                ResourceType.WOOD,
                ResourceType.ROCK
        );
    }
}
