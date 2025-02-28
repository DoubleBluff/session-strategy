package org.doublebluff.session_strategy.game.api.event;

public enum EventType {
    NEW_SETTLE,
    NEW_ROAD,
    NEW_RESOURCES, // получение новых ресурсов
    RESOURCES_SPENT, // отправка ресурсов за строительство
    NEXT_MOVE, // смена хода
    PLAYER_WON
}
