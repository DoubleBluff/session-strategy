package org.doublebluff.session_strategy.game;

import lombok.RequiredArgsConstructor;
import org.doublebluff.session_strategy.game.player.Player;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class EndGameChecker {

    public Optional<Player> getWinner(Collection<Player> players) {
        return players.stream().filter(p -> isWinner(p)).findFirst();
    }

    private boolean isWinner(Player player) {
        if (player.getSettles().size() == 5) {
            return true;
        }
        return false;
    }
}
