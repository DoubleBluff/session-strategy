package org.doublebluff.session_strategy.game.api.player;

import lombok.RequiredArgsConstructor;
import org.doublebluff.session_strategy.lobby.User;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

@Component
@RequiredArgsConstructor
public class PlayerFactory {

    private final ResourceFactory resourceFactory;

    public List<Player> get(Collection<User> users) {
        PlayerColor.PlayerColorRandomProducer playerColorRandomProducer = PlayerColor.randomProducer();
        return users.stream()
                .map(user -> new Player(user,
                        playerColorRandomProducer.next().orElseThrow(() -> new RuntimeException("DIDN'T MATCH PLAYERS AND COLORS COUNT")),
                        resourceFactory.getDefault()))
                .toList();
    }
}
