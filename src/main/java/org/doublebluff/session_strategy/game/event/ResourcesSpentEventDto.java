package org.doublebluff.session_strategy.game.event;

import lombok.Getter;
import org.doublebluff.session_strategy.game.resource.ResourceType;

import java.util.Collection;
import java.util.UUID;

@Getter
public class ResourcesSpentEventDto extends EventDto {

    private final UUID userId;

    private final Collection<ResourceType> resources;

    public ResourcesSpentEventDto(UUID userId, Collection<ResourceType> resources) {
        super(EventType.RESOURCES_SPENT);
        this.userId = userId;
        this.resources = resources;
    }
}
