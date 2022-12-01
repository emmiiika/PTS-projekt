package sk.uniba.fmph.dcs;

import java.util.List;
import java.util.Optional;

public class Game {

    private List<Player> playerList;
    private DrawingAndTrashPile dAndTPile;
    private SleepingQueens sleepingQueens;

    private int onTurn;

    public Game(){}

    public Optional<GameState> play(int playerIdx, List<Position> cards){
        this.onTurn = playerIdx;
        return Optional.empty();
    }    

    public List<Player> getPlayersList(){
        return playerList;
    }

    public int playerOnTurn(){
        return onTurn;
    }
}
