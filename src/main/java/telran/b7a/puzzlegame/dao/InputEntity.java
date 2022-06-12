package telran.b7a.puzzlegame.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "attemps")
public class InputEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer playerId;
    private Integer puzzleId;
    @ElementCollection(targetClass = Integer.class)
    private Set<Integer> foundItems;
}
