package telran.b7a.puzzlegame.mapper;

import org.mapstruct.Mapper;
import telran.b7a.puzzlegame.model.Puzzle;
import telran.b7a.puzzlegame.model.PuzzleRequest;

@Mapper(componentModel = "spring")
public interface PuzzleToDtoMapper {
    Puzzle PuzzleAddRequestToPuzzle(PuzzleRequest puzzleRequest);
    Puzzle PuzzleEditRequestToPuzzle(Long id, PuzzleRequest puzzleRequest);
}
