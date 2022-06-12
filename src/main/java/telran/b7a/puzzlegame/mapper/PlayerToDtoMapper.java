package telran.b7a.puzzlegame.mapper;

import org.mapstruct.Mapper;
import telran.b7a.puzzlegame.model.Player;
import telran.b7a.puzzlegame.model.PlayerRequest;

@Mapper(componentModel = "spring")
public interface PlayerToDtoMapper {
    Player AddPlayerRequestToPlayer(PlayerRequest playerRequest);
    Player EditPlayerRequestToPlayer(Long id, PlayerRequest playerRequest);
}
