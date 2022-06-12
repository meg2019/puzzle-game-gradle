package telran.b7a.puzzlegame.mapper;

import org.mapstruct.Mapper;
import telran.b7a.puzzlegame.dao.PlayerEntity;
import telran.b7a.puzzlegame.model.Player;

@Mapper(componentModel = "spring")
public interface PlayerToPlayerEntityMapper {
    PlayerEntity playerToPlayerEntityMapper(Player player);

    Player playerEntityToPlayer(PlayerEntity playerEntity);
}
