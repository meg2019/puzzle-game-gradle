package telran.b7a.puzzlegame.model;

import lombok.Data;

import java.util.Set;

@Data
public class ResultRequest {
    private String name;
    Set<Integer> missingItems;
}
