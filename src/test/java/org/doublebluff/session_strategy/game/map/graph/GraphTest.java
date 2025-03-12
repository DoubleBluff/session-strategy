package org.doublebluff.session_strategy.game.map.graph;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GraphTest {

    @Test
    public void correctInit() {
        Graph<Object, Object> graph = new Graph<>(3, 3, new Factory<Object, Object>() {
            @Override
            public Object getNodeObj() {
                return null;
            }

            @Override
            public Object getEdgeObj() {
                return null;
            }
        });


        // корректно сформирована верхняя левая нода
        Node<Object, Object> actualNode = graph.getByCoordinates(0, 0);
        assertEquals(2, actualNode.getEdges().size(), "Некорректное количество ребер");
        assertTrue(actualNode.getEdges().stream().flatMap(e -> e.getNodes().stream()).anyMatch(n -> n.equals(graph.getByCoordinates(0, 1))));
        assertTrue(actualNode.getEdges().stream().flatMap(e -> e.getNodes().stream()).anyMatch(n -> n.equals(graph.getByCoordinates(1, 0))));

        // корректно сформирована верхняя правая нода
        actualNode = graph.getByCoordinates(2, 0);
        assertEquals(2, actualNode.getEdges().size(), "Некорректное количество ребер");
        assertTrue(actualNode.getEdges().stream().flatMap(e -> e.getNodes().stream()).anyMatch(n -> n.equals(graph.getByCoordinates(2, 1))));
        assertTrue(actualNode.getEdges().stream().flatMap(e -> e.getNodes().stream()).anyMatch(n -> n.equals(graph.getByCoordinates(1, 0))));

        // корректно сформирована нижняя правая нода
        actualNode = graph.getByCoordinates(2, 2);
        assertEquals(2, actualNode.getEdges().size(), "Некорректное количество ребер");
        assertTrue(actualNode.getEdges().stream().flatMap(e -> e.getNodes().stream()).anyMatch(n -> n.equals(graph.getByCoordinates(2, 1))));
        assertTrue(actualNode.getEdges().stream().flatMap(e -> e.getNodes().stream()).anyMatch(n -> n.equals(graph.getByCoordinates(1, 2))));

        // корректно сформирована нижняя левая нода
        actualNode = graph.getByCoordinates(0, 2);
        assertEquals(2, actualNode.getEdges().size(), "Некорректное количество ребер");
        assertTrue(actualNode.getEdges().stream().flatMap(e -> e.getNodes().stream()).anyMatch(n -> n.equals(graph.getByCoordinates(0, 1))));
        assertTrue(actualNode.getEdges().stream().flatMap(e -> e.getNodes().stream()).anyMatch(n -> n.equals(graph.getByCoordinates(1, 2))));

        // корректно сформирована верхняя нода
        actualNode = graph.getByCoordinates(1, 0);
        assertEquals(3, actualNode.getEdges().size(), "Некорректное количество ребер");
        assertTrue(actualNode.getEdges().stream().flatMap(e -> e.getNodes().stream()).anyMatch(n -> n.equals(graph.getByCoordinates(0, 0))));
        assertTrue(actualNode.getEdges().stream().flatMap(e -> e.getNodes().stream()).anyMatch(n -> n.equals(graph.getByCoordinates(2, 0))));
        assertTrue(actualNode.getEdges().stream().flatMap(e -> e.getNodes().stream()).anyMatch(n -> n.equals(graph.getByCoordinates(1, 1))));

        // корректно сформирована правая нода
        actualNode = graph.getByCoordinates(2, 1);
        assertEquals(3, actualNode.getEdges().size(), "Некорректное количество ребер");
        assertTrue(actualNode.getEdges().stream().flatMap(e -> e.getNodes().stream()).anyMatch(n -> n.equals(graph.getByCoordinates(2, 0))));
        assertTrue(actualNode.getEdges().stream().flatMap(e -> e.getNodes().stream()).anyMatch(n -> n.equals(graph.getByCoordinates(2, 2))));
        assertTrue(actualNode.getEdges().stream().flatMap(e -> e.getNodes().stream()).anyMatch(n -> n.equals(graph.getByCoordinates(1, 1))));

        // корректно сформирована нижняя нода
        actualNode = graph.getByCoordinates(1, 2);
        assertEquals(3, actualNode.getEdges().size(), "Некорректное количество ребер");
        assertTrue(actualNode.getEdges().stream().flatMap(e -> e.getNodes().stream()).anyMatch(n -> n.equals(graph.getByCoordinates(0, 2))));
        assertTrue(actualNode.getEdges().stream().flatMap(e -> e.getNodes().stream()).anyMatch(n -> n.equals(graph.getByCoordinates(2, 2))));
        assertTrue(actualNode.getEdges().stream().flatMap(e -> e.getNodes().stream()).anyMatch(n -> n.equals(graph.getByCoordinates(1, 1))));

        // корректно сформирована левая нода
        actualNode = graph.getByCoordinates(0, 1);
        assertEquals(3, actualNode.getEdges().size(), "Некорректное количество ребер");
        assertTrue(actualNode.getEdges().stream().flatMap(e -> e.getNodes().stream()).anyMatch(n -> n.equals(graph.getByCoordinates(0, 0))));
        assertTrue(actualNode.getEdges().stream().flatMap(e -> e.getNodes().stream()).anyMatch(n -> n.equals(graph.getByCoordinates(0, 2))));
        assertTrue(actualNode.getEdges().stream().flatMap(e -> e.getNodes().stream()).anyMatch(n -> n.equals(graph.getByCoordinates(1, 1))));

        // корректно сформирована нода в середине
        actualNode = graph.getByCoordinates(1, 1);
        assertEquals(4, actualNode.getEdges().size(), "Некорректное количество ребер");
        assertTrue(actualNode.getEdges().stream().flatMap(e -> e.getNodes().stream()).anyMatch(n -> n.equals(graph.getByCoordinates(1, 0))));
        assertTrue(actualNode.getEdges().stream().flatMap(e -> e.getNodes().stream()).anyMatch(n -> n.equals(graph.getByCoordinates(0, 1))));
        assertTrue(actualNode.getEdges().stream().flatMap(e -> e.getNodes().stream()).anyMatch(n -> n.equals(graph.getByCoordinates(2, 1))));
        assertTrue(actualNode.getEdges().stream().flatMap(e -> e.getNodes().stream()).anyMatch(n -> n.equals(graph.getByCoordinates(1, 2))));
    }

}