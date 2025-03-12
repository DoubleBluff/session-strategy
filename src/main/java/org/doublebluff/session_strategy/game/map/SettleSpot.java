package org.doublebluff.session_strategy.game.map;

import lombok.Getter;
import lombok.Setter;
import org.doublebluff.session_strategy.game.player.Player;

public class SettleSpot {

    @Getter
    @Setter
    private Player player;

    public boolean isEmpty() {
        return player == null;
    }
}
