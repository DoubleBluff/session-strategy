package org.doublebluff.session_strategy.game.api.player;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.doublebluff.session_strategy.game.api.ResourceType;
import org.doublebluff.session_strategy.lobby.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Getter
@RequiredArgsConstructor
public class Player {

    private final User user;

    private final PlayerColor color;

    private final List<ResourceType> resources;

    public void spentResources(Collection<ResourceType> price) {
        price.forEach(resources::remove);
    }

    public boolean areResourcesEnough(Collection<ResourceType> price) {
        List<ResourceType> playerResources = new ArrayList<>(this.resources);
        for (ResourceType resourceType : price) {
            if (!playerResources.remove(resourceType)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof Player player) {
            Objects.equals(user, player.user);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(user);
    }
}
