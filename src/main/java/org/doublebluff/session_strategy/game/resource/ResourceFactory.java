package org.doublebluff.session_strategy.game.resource;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ResourceFactory {

    public List<ResourceType> getDefault() {
        return List.of();
    }
}
