package telran.b7a.puzzlegame.service;

import telran.b7a.puzzlegame.model.Player;

import java.util.List;

public interface PlayerService {
    Player getPlayerById(Long id);

    List<Player> getAllPlayers();

    void addPlayer(Player player);

    void editPlayer(Player player);
}
