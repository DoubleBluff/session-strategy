package org.doublebluff.session_strategy.game.map.graph;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@EqualsAndHashCode
@RequiredArgsConstructor
public class NodeCoordinate {

    private final int x;

    private final int y;
}
