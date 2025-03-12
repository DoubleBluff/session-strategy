package org.doublebluff.session_strategy.game.map.graph;

import java.util.HashSet;
import java.util.Set;

public class Graph<T, R> {

    private final Node<T, R>[][] nodes;

    public Graph(int width, int height, Factory<T, R> factory) {
        nodes = new Node[width][height];

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                nodes[x][y] = new Node<>(new HashSet<>(), factory.getNodeObj());

            }
        }

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                Node<T, R> node = nodes[x][y];
                if (x == 0) {
                    if (y == height - 1) {
                        // нода в нижнем левом углу
                        connectOnlyRight(factory, nodes, x, y, node);
                    } else {
                        // ноды вдоль левой границы с верхним углом
                        connectRightAndDown(factory, nodes, x, y, node);
                    }
                } else if (x == width - 1) {
                    if (y == height - 1) {
                        // нода в нижнем правом углу уже соединена
                    } else {
                        // ноды вдоль правой границы c верхним углом
                        connectOnlyDown(factory, nodes, x, y, node);
                    }
                } else if (y == height - 1) {
                    // ноды вдоль нижней границы (без углов)
                    connectOnlyRight(factory, nodes, x, y, node);
                } else {
                    // ноды в середине и вдоль врерхней границы (без углов)
                    connectRightAndDown(factory, nodes, x, y, node);
                }
            }
        }

    }

    private static <T, R> void connectOnlyDown(Factory<T, R> factory, Node<T, R>[][] nodes, int x, int y, Node<T, R> node) {
        Node<T, R> downNode = nodes[x][y + 1];
        Edge<T, R> toDown = new Edge<>(Set.of(nodes[x][y], downNode), factory.getEdgeObj());
        node.getEdges().add(toDown);
        downNode.getEdges().add(toDown);
    }

    private static <T, R> void connectOnlyRight(Factory<T, R> factory, Node<T, R>[][] nodes, int x, int y, Node<T, R> node) {
        Node<T, R> rightNode = nodes[x + 1][y];
        Edge<T, R> toRight = new Edge<>(Set.of(nodes[x][y], rightNode), factory.getEdgeObj());
        node.getEdges().add(toRight);
        rightNode.getEdges().add(toRight);
    }

    private static <T, R> void connectRightAndDown(Factory<T, R> factory, Node<T, R>[][] nodes, int x, int y, Node<T, R> node) {
        Node<T, R> rightNode = nodes[x + 1][y];
        Node<T, R> downNode = nodes[x][y + 1];

        Edge<T, R> toRight = new Edge<>(Set.of(nodes[x][y], rightNode), factory.getEdgeObj());
        Edge<T, R> toDown = new Edge<>(Set.of(nodes[x][y], downNode), factory.getEdgeObj());

        node.getEdges().add(toRight);
        node.getEdges().add(toDown);

        rightNode.getEdges().add(toRight);
        downNode.getEdges().add(toDown);
    }

    public Node<T, R> getByCoordinates(int x, int y) {
        return nodes[x][y];
    }


}
