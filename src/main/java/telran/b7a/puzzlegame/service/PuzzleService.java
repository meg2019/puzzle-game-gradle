package telran.b7a.puzzlegame.service;

import telran.b7a.puzzlegame.model.Puzzle;

import java.util.List;

public interface PuzzleService {
    Puzzle getPuzzleById(Long id);

    List<Puzzle> getAllPuzzle();

    void addPuzzle(Puzzle puzzle);

    void editPuzzle(Puzzle puzzle);
}
