package telran.b7a.puzzlegame.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import telran.b7a.puzzlegame.dao.PuzzleEntity;
import telran.b7a.puzzlegame.dao.PuzzleRepository;
import telran.b7a.puzzlegame.exception.PuzzleNotFoundException;
import telran.b7a.puzzlegame.mapper.PuzzleToPuzzleEntityMapper;
import telran.b7a.puzzlegame.model.Puzzle;

import java.util.List;
import java.util.stream.StreamSupport;

import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
public class PuzzleServiceImpl implements PuzzleService {
    private final PuzzleRepository repository;
    private final PuzzleToPuzzleEntityMapper mapper;


    @Override
    public Puzzle getPuzzleById(Long id) {
        PuzzleEntity puzzleEntity = repository.findById(id)
                .orElseThrow(() -> new PuzzleNotFoundException("Puzzle with id: " + id + " not found!"));
        return mapper.puzzleEntityToPuzzle(puzzleEntity);
    }

    @Override
    public List<Puzzle> getAllPuzzle() {
        Iterable<PuzzleEntity> iterable = repository.findAll();
        return StreamSupport.stream(iterable.spliterator(), false)
                .map(mapper::puzzleEntityToPuzzle)
                .collect(toList());
    }

    @Override
    public void addPuzzle(Puzzle puzzle) {
        PuzzleEntity puzzleEntity = mapper.puzzleToPuzzleEntity(puzzle);
        repository.save(puzzleEntity);

    }

    @Override
    public void editPuzzle(Puzzle puzzle) {
        if (!repository.existsById(puzzle.getId())){
            throw new PuzzleNotFoundException("Puzzle with id: " + puzzle.getId() + " not found");
        }
        PuzzleEntity puzzleEntity = mapper.puzzleToPuzzleEntity(puzzle);
        repository.save(puzzleEntity);
    }
}
