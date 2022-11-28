package sk.uniba.fmph.dcs;

import java.util.List;
import java.util.Optional;

public class Game {

    private List<Player> playerList;
    private DrawingAndTrashPile dAndTPile;
    private SleepingQueens sleepingQueens;

    public Game(){}

    public Optional<GameState> play(int playerIdx, List<Position> cards){
        return Optional.empty();
    }    
}
