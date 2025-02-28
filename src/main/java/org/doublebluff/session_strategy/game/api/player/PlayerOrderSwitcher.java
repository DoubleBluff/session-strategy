package org.doublebluff.session_strategy.game.api.player;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@AllArgsConstructor
public class PlayerOrderSwitcher {

    private final List<Player> players;

    private int activePlayerPointer;

    public PlayerOrderSwitcher(Collection<Player> players) {
        this(new ArrayList<>(players), 0);
    }

    public boolean isActivePlayer(Player player) {
        return players.get(activePlayerPointer).equals(player);
    }

    public Player switchPlayer() {
        if (activePlayerPointer == players.size() - 1) {
            activePlayerPointer = 0;
        } else {
            activePlayerPointer++;
        }
        return players.get(activePlayerPointer);
    }
}
