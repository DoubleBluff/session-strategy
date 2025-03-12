package org.doublebluff.session_strategy.game.map.graph;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Set;

@Getter
@RequiredArgsConstructor
public class Node<T, R> {

    private final Set<Edge<T, R>> edges;

    private final T obj;

}
