package telran.b7a.puzzlegame.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import telran.b7a.puzzlegame.mapper.PlayerToDtoMapper;
import telran.b7a.puzzlegame.mapper.PuzzleToDtoMapper;
import telran.b7a.puzzlegame.model.*;
import telran.b7a.puzzlegame.service.GameService;
import telran.b7a.puzzlegame.service.PlayerService;
import telran.b7a.puzzlegame.service.PuzzleService;


import java.util.List;

@RestController
@RequestMapping("/game")
@RequiredArgsConstructor
public class PuzzleController {
    private final PuzzleService puzzleService;
    private final PlayerService playerService;
    private final PlayerToDtoMapper playerMapper;
    private final PuzzleToDtoMapper puzzleMapper;

    private final GameService gameService;

    @Transactional(readOnly = true)
    @GetMapping("/player/{playerId}")
    public Player getPlayerById(@PathVariable Long playerId) {
        return playerService.getPlayerById(playerId);
    }

    @Transactional(readOnly = true)
    @PostMapping("/player")
    public void addPlayer(@RequestBody PlayerRequest addPlayerRequest) {
        playerService.addPlayer(playerMapper.AddPlayerRequestToPlayer(addPlayerRequest));
    }
    @Transactional(readOnly = true)
    @GetMapping("/puzzle/{puzzleId}")
    public Puzzle getPuzzleById(@PathVariable Long puzzleId) {
        return puzzleService.getPuzzleById(puzzleId);
    }

    @Transactional
    @PostMapping("/puzzle")
    public void addPuzzle(@RequestBody PuzzleRequest addPuzzleRequest) {
        puzzleService.addPuzzle(puzzleMapper.PuzzleAddRequestToPuzzle(addPuzzleRequest));
    }

    @Transactional(readOnly = true)
    @GetMapping("/players")
    public List<Player> getAllPlayers() {
        return playerService.getAllPlayers();
    }

    @Transactional(readOnly = true)
    @GetMapping("/puzzles")
    public List<Puzzle> getAllPuzzles() {
        return puzzleService.getAllPuzzle();
    }

    @Transactional
    @PostMapping("/game")
    public Result game(@RequestBody InputRequest inputRequest) {
        return gameService.game(inputRequest);
    }

}
