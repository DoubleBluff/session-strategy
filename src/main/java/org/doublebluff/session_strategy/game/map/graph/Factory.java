package org.doublebluff.session_strategy.game.map.graph;

public interface Factory<T, R> {

    T getNodeObj();

    R getEdgeObj();
}
