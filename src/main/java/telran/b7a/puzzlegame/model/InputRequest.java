package telran.b7a.puzzlegame.model;

import lombok.Data;

import java.util.Set;

@Data
public class InputRequest {
    private Long playerId;
    private Long puzzleId;
    private Set<Integer> foundItems;
}
