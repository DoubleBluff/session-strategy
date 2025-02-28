package org.doublebluff.session_strategy.game.api.player;

import org.doublebluff.session_strategy.lobby.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class PlayerOrderSwitcherTest {

    @Autowired
    private PlayerFactory playerFactory;

    @Test
    public void switchToNext() {
        List<Player> players = playerFactory.get(List.of(
                new User(UUID.randomUUID(), "firstUser"),
                new User(UUID.randomUUID(), "secondUser")
        ));
        PlayerOrderSwitcher playerOrderSwitcher = new PlayerOrderSwitcher(players);
        Player expected = players.get(1);

        Player actual = playerOrderSwitcher.switchPlayer();

        assertEquals(expected, actual, "Получен некорректный следующий игрок");
    }

    @Test
    public void switchFromLastToFirst() {
        List<Player> players = playerFactory.get(List.of(
                new User(UUID.randomUUID(), "firstUser"),
                new User(UUID.randomUUID(), "secondUser")
        ));
        PlayerOrderSwitcher playerOrderSwitcher = new PlayerOrderSwitcher(players);
        playerOrderSwitcher.switchPlayer();
        Player expected = players.get(0);

        Player actual = playerOrderSwitcher.switchPlayer();

        assertEquals(expected, actual, "Получен НЕ первый игрок, после последнего");
    }

    @Test
    public void isFirstActiveByDefault() {
        List<Player> players = playerFactory.get(List.of(
                new User(UUID.randomUUID(), "firstUser"),
                new User(UUID.randomUUID(), "secondUser")
        ));
        PlayerOrderSwitcher playerOrderSwitcher = new PlayerOrderSwitcher(players);

        boolean actual = playerOrderSwitcher.isActivePlayer(players.get(0));

        assertTrue(actual, "Первый пользователь по-умолчанию НЕ считается активным");
    }

    @Test
    public void isNextActiveAfterSwitch() {
        // Arrange
        PlayerOrderSwitcher playerOrderSwitcher = new PlayerOrderSwitcher(playerFactory.get(List.of(
                new User(UUID.randomUUID(), "firstUser"),
                new User(UUID.randomUUID(), "secondUser")
        )));
        Player player = playerOrderSwitcher.switchPlayer();

        // Act
        boolean actual = playerOrderSwitcher.isActivePlayer(player);

        // Assert
        assertTrue(actual, "После переключения очереди, следующий пользователь НЕ считается активным");
    }


}