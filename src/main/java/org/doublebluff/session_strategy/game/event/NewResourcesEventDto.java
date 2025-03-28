package org.doublebluff.session_strategy.game.event;

import lombok.Getter;
import org.doublebluff.session_strategy.game.resource.ResourceType;

import java.util.Collection;

@Getter
public class NewResourcesEventDto extends EventDto {

    private final Collection<ResourceType> resources;

    public NewResourcesEventDto(Collection<ResourceType> resources) {
        super(EventType.NEW_RESOURCES);
        this.resources = resources;
    }


}
