package org.doublebluff.session_strategy.game.map;

import lombok.RequiredArgsConstructor;
import org.doublebluff.session_strategy.game.map.graph.Factory;
import org.doublebluff.session_strategy.game.map.graph.Graph;
import org.doublebluff.session_strategy.game.player.Player;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class MapInnerApiImpl implements MapInnerApi {

    private final SpotType[][] spots;

    private final Graph<SettleSpot, RoadSpot> settlesAndRoads;

    public MapInnerApiImpl(SpotType[][] spots) {
        this(spots, spotsToSettlesAndRoads(spots));
    }

    private static Graph<SettleSpot, RoadSpot> spotsToSettlesAndRoads(SpotType[][] spots) {
        return new Graph<>(spots.length, spots[0].length, new Factory<>() {
            @Override
            public SettleSpot getNodeObj() {
                return new SettleSpot();
            }

            @Override
            public RoadSpot getEdgeObj() {
                return new RoadSpot();
            }
        });
    }



    @Override
    public void buildRoad(Player player, RoadCoordinatesDto roadCoordinatesDto) {
        RoadCoordinate roadCoordinate = new RoadCoordinate(
                roadCoordinatesDto.getSettleSpotsCoordinates()
                        .stream()
                        .map(s -> new SettleCoordinate(s.getLeftUp(), s.getRightUp(), s.getRightDown(), s.getLeftDown()))
                        .collect(Collectors.toSet())
        );
        RoadSpot roadSpot = roadSpotsByCoordinate.get(roadCoordinate);
        if (roadSpot == null) {
            throw new RuntimeException("ROAD SPOT NOT FOUND");
        }
        if (!roadSpot.isEmpty()) {
            throw new RuntimeException("ROAD SPOT ISN'T EMPTY");
        }
        if (!hasNearRoadWithSamePlayer(roadCoordinate, player)) {
            throw new RuntimeException("NO ROAD NEAR");
        }
        roadSpot.setPlayer(player);
    }

    @Override
    public void buildSettle(Player player, SettleCoordinatesDto settleCoordinatesDto) {
        SettleCoordinate settleCoordinate = new SettleCoordinate(
                settleCoordinatesDto.getLeftUp(),
                settleCoordinatesDto.getRightUp(),
                settleCoordinatesDto.getRightDown(),
                settleCoordinatesDto.getLeftDown()
        );
        SettleSpot settleSpot = settleSpotsByCoordinate.get(settleCoordinate);
        if (settleSpot == null) {
            throw new RuntimeException("SETTLE SPOT NOT FOUND");
        }
        if (!settleSpot.isEmpty()) {
            throw new RuntimeException("SETTLE SPOT ISN'T EMPTY");
        }
        if (!hasNearRoadWithSamePlayer(settleCoordinate, player)) {
            throw new RuntimeException("NO ROAD NEAR");
        }
        settleSpot.setPlayer(player);
    }

    @Override
    public List<SpotType> getSpotsAround(SettleCoordinatesDto settleCoordinatesDto) {
        SettleCoordinate settleCoordinate = new SettleCoordinate(
                settleCoordinatesDto.getLeftUp(),
                settleCoordinatesDto.getRightUp(),
                settleCoordinatesDto.getRightDown(),
                settleCoordinatesDto.getLeftDown()
        );
        return settleCoordinate.getSpotsCoordinatesAround()
                .stream()
                .map(spotCoordinate -> spots[spotCoordinate.getX()][spotCoordinate.getY()])
                .toList();
    }

    private boolean hasNearRoadWithSamePlayer(SettleCoordinate settleCoordinate, Player player) {
        return false;
    }

    private boolean hasNearRoadWithSamePlayer(RoadCoordinate roadCoordinate, Player player) {
        return false;
    }
}
