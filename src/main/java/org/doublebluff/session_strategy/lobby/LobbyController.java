package org.doublebluff.session_strategy.lobby;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.doublebluff.session_strategy.game.GameDto;
import org.doublebluff.session_strategy.lobby.dto.LobbyDto;
import org.doublebluff.session_strategy.lobby.service.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/lobbies")
@RequiredArgsConstructor
public class LobbyController {

    private final LobbyGetService lobbyGetService;

    private final LobbyCreateService lobbyCreateService;

    private final LobbyUpdateService lobbyUpdateService;

    private final LobbyJoinService lobbyJoinService;

    private final LobbyLeaveService lobbyLeaveService;

    private final LobbyStartService lobbyStartService;

    @GetMapping("/v1/{lobbyId}")
    public LobbyDto getById(@PathVariable UUID lobbyId) {
        return lobbyGetService.getById(lobbyId);
    }

    @GetMapping("/v1")
    public List<LobbyDto> getAll() {
        return lobbyGetService.getAll();
    }

    @PostMapping("/v1")
    public LobbyDto create(@RequestBody @Valid LobbyDto lobbyDto) {
        return lobbyCreateService.create(lobbyDto, new User(UUID.randomUUID(), "username"));
    }

    @PutMapping("/v1/{lobbyId}")
    public LobbyDto update(@PathVariable UUID lobbyId, @RequestBody @Valid LobbyDto lobbyDto) {
        return lobbyUpdateService.update(lobbyId, lobbyDto);
    }

    @PatchMapping("/v1/{lobbyId}/join")
    public LobbyDto join(@PathVariable UUID lobbyId) {
        return lobbyJoinService.join(lobbyId, new User(UUID.randomUUID(), "username"));
    }

    @PatchMapping("/v1/{lobbyId}/leave")
    public LobbyDto leave(@PathVariable UUID lobbyId) {
        return lobbyLeaveService.leave(lobbyId, new User(UUID.randomUUID(), "username"));
    }

    @PatchMapping("/v1/{lobbyId}/start")
    public GameDto start(@PathVariable UUID lobbyId) {
        return lobbyStartService.start(lobbyId);
    }
}
