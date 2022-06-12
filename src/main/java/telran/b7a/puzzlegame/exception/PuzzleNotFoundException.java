package telran.b7a.puzzlegame.exception;

public class PuzzleNotFoundException  extends RuntimeException{
    public PuzzleNotFoundException(String message) {
        super(message);
    }

    public PuzzleNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
