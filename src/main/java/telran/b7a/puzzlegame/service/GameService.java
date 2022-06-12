package telran.b7a.puzzlegame.service;

import telran.b7a.puzzlegame.model.InputRequest;
import telran.b7a.puzzlegame.model.Result;

public interface GameService {
    Result game(InputRequest inputRequest);

}
