package org.doublebluff.session_strategy.game;

import lombok.RequiredArgsConstructor;
import org.doublebluff.session_strategy.game.event.EventDto;
import org.doublebluff.session_strategy.game.player.Player;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.function.Function;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class EventStorage {

    private static final int MAX_EVENT_PACK_SIZE = 10;

    private final Map<Player, Queue<EventDto>> eventQueuesByPlayer;

    public EventStorage(Collection<Player> players) {
        this(players.stream().collect(Collectors.toMap(Function.identity(), player -> new ConcurrentLinkedQueue<>())));
    }

    public List<EventDto> getNewEvents(Player player) {
        ArrayList<EventDto> events = new ArrayList<>();
        for (int i = 0; i < MAX_EVENT_PACK_SIZE; i++) {
            Queue<EventDto> queue = eventQueuesByPlayer.get(player);
            if (!queue.isEmpty()) {
                events.add(queue.poll());
            }
        }
        return events;
    }

    public void pushEvents(Player player, List<EventDto> events) {
        eventQueuesByPlayer.get(player).addAll(events);
    }
}
