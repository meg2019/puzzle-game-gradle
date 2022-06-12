package telran.b7a.puzzlegame.model;

import lombok.Value;

import java.util.Set;

@Value
public class Result {
    Long id;
    String name;
    Set<Integer> missingItems;
}
