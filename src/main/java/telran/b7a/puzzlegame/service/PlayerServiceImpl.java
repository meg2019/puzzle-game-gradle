package telran.b7a.puzzlegame.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import telran.b7a.puzzlegame.dao.PlayerEntity;
import telran.b7a.puzzlegame.dao.PlayerRepository;
import telran.b7a.puzzlegame.exception.PlayerNotFoundException;
import telran.b7a.puzzlegame.mapper.PlayerToPlayerEntityMapper;
import telran.b7a.puzzlegame.model.Player;

import java.util.List;
import java.util.stream.StreamSupport;

import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
public class PlayerServiceImpl implements PlayerService {
    private final PlayerRepository repository;
    private final PlayerToPlayerEntityMapper mapper;

    @Override
    public Player getPlayerById(Long id) {
        PlayerEntity playerEntity = repository.findById(id)
                .orElseThrow(() -> new PlayerNotFoundException("Player with id: " + id + " not found"));
        return mapper.playerEntityToPlayer(playerEntity);
    }

    @Override
    public List<Player> getAllPlayers() {
        Iterable<PlayerEntity> iterable = repository.findAll();
        return StreamSupport.stream(iterable.spliterator(), false)
                .map(mapper::playerEntityToPlayer)
                .collect(toList());
    }

    @Override
    public void addPlayer(Player player) {
        PlayerEntity playerEntity = mapper.playerToPlayerEntityMapper(player);
        repository.save(playerEntity);
    }

    @Override
    public void editPlayer(Player player) {
        if (!repository.existsById(player.getId())) {
            throw new PlayerNotFoundException("Player with id: " + player.getId() + " not found");
        }
        PlayerEntity playerEntity = mapper.playerToPlayerEntityMapper(player);
        repository.save(playerEntity);
    }
}
