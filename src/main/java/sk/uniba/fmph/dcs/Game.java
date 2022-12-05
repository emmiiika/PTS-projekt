package sk.uniba.fmph.dcs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

public class Game {

    private List<Player> playerList;
    private DrawingAndTrashPile dAndTPile;
    private SleepingQueens sleepingQueens;
    private int onTurn;

    public Game(List<Player> playerList, DrawingAndTrashPile dAndTPile, SleepingQueens sleepingQueens){
        this.playerList = playerList;
        this.dAndTPile = dAndTPile;
        this.sleepingQueens = sleepingQueens;
        this.onTurn = 0;
    }

    public Optional<GameState> play(int playerIdx, List<Position> cards){
        GameState gameState = new GameState();
        gameState.numberOfPlayers = playerList.size();
        gameState.onTurn = onTurn;
//        gameState.sleepingQueens =
//        gameState.cards = playerList.get(onTurn).getPlayersCards()
//        gameState.awokenQueens =
//        gameState.cardsDiscardedLastTurn = dAndTPile.getCardsDiscardedThisTurn();


        return Optional.of(gameState);
    }    

    public List<Player> getPlayersList(){
        return playerList;
    }

    public int playerOnTurn(){
        return onTurn;
    }
}
