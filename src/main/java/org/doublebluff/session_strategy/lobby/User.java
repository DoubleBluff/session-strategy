package org.doublebluff.session_strategy.lobby;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Objects;
import java.util.UUID;

@Getter
@RequiredArgsConstructor
public class User {

    private final UUID id;

    private final String username;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof User user) {
            return Objects.equals(id, user.id);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
