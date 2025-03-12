package org.doublebluff.session_strategy.game.player;

import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;

public enum PlayerColor {
    RED,
    GREEN,
    BLUE,
    YELLOW;

    public static PlayerColorRandomProducer randomProducer() {
        return new PlayerColorRandomProducer(PlayerColor.values());
    }

    @RequiredArgsConstructor
    public static class PlayerColorRandomProducer {

        private final Queue<PlayerColor> colors;

        public PlayerColorRandomProducer(PlayerColor[] colors) {
            this(new LinkedList<>(Arrays.asList(colors)));
        }

        public Optional<PlayerColor> next() {
            return Optional.ofNullable(colors.poll());
        }
    }
}
