package org.doublebluff.session_strategy.game.resource;

import lombok.RequiredArgsConstructor;
import org.doublebluff.session_strategy.game.GameInnerApi;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ResourceGeneratorFactory {

    public ResourceGenerator get(GameInnerApi gameInnerApi) {
        return new ResourceGenerator(gameInnerApi, 0);
    }
}
