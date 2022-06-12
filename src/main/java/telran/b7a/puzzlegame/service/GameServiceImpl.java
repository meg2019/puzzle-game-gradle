package telran.b7a.puzzlegame.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import telran.b7a.puzzlegame.dao.*;
import telran.b7a.puzzlegame.exception.PlayerNotFoundException;
import telran.b7a.puzzlegame.exception.PuzzleNotFoundException;
import telran.b7a.puzzlegame.mapper.ResultToResultEntityMapper;
import telran.b7a.puzzlegame.model.InputRequest;
import telran.b7a.puzzlegame.model.Result;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class GameServiceImpl implements GameService {

    private final PuzzleRepository puzzleRepository;
    private final PlayerRepository playerRepository;

    private final ResultRepository resultRepository;
    private final ResultToResultEntityMapper mapper;

    @Override
    public Result game(InputRequest inputRequest) {
        PuzzleEntity sessionPuzzle = puzzleRepository.findById(inputRequest.getPuzzleId()).orElseThrow(
                () -> new PuzzleNotFoundException("Puzzle with id: " + inputRequest.getPuzzleId() + " not found")
        );
        PlayerEntity sessionPlayer = playerRepository.findById(inputRequest.getPlayerId()).orElseThrow(
                () -> new PlayerNotFoundException("Player with id: " + inputRequest.getPlayerId() + " not found")
        );
        Integer numOfItems = sessionPuzzle.getNumOfItems();
        Set<Integer> puzzle = new HashSet<>();
        for (int i = 1; i <= numOfItems; i++) {
            puzzle.add(i);
        }
        puzzle.removeAll(inputRequest.getFoundItems());
        ResultEntity resultEntity = new ResultEntity();
        resultEntity.setName(sessionPlayer.getName());
        resultEntity.setMissingItems(puzzle);
        resultRepository.save(resultEntity);
        return mapper.resultEntityToResultMapper(resultEntity);

    }
}
