package org.doublebluff.session_strategy.game.map.graph;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Set;

@Getter
@RequiredArgsConstructor
public class Edge<T, R> {

    private final Set<Node<T, R>> nodes;

    private final R obj;

}
