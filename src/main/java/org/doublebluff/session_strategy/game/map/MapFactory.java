package org.doublebluff.session_strategy.game.map;

import org.springframework.stereotype.Component;

@Component
public class MapFactory {

    public MapInnerApi getDefault() {
        return new MapInnerApiImpl(
                new SpotType[][] {
                        { SpotType.SEA },
                        {}
                }
        );
    }
}
