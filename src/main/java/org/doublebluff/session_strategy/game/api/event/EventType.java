package org.doublebluff.session_strategy.game.api.event;

public enum EventType {
    NEW_SETTLE,
    NEW_ROAD,
    RESOURCES_CHANGED, // раздача новых ресурсов
    NEXT_MOVE, // смена хода
    PLAYER_WIN
}
