package telran.b7a.puzzlegame.mapper;

import org.mapstruct.Mapper;
import telran.b7a.puzzlegame.dao.PuzzleEntity;
import telran.b7a.puzzlegame.model.Puzzle;

@Mapper(componentModel = "spring")
public interface PuzzleToPuzzleEntityMapper {
    PuzzleEntity puzzleToPuzzleEntity(Puzzle puzzle);

    Puzzle puzzleEntityToPuzzle(PuzzleEntity puzzleEntity);
}
