package sk.uniba.fmph.dcs;

import java.util.*;

public class Game {

    private List<Player> playerList;
    private DrawingAndTrashPile dAndTPile;
    private SleepingQueens sleepingQueens;
    private int onTurn;

    public Game(DrawingAndTrashPile dAndTPile, SleepingQueens sleepingQueens){
        this.playerList = playerList;
        this.dAndTPile = dAndTPile;
        this.sleepingQueens = sleepingQueens;
        this.onTurn = 0;
    }

    public Optional<GameState> play(int playerIdx, List<Position> cards){
        GameState gameState = new GameState();
        gameState.numberOfPlayers = playerList.size();
        gameState.onTurn = onTurn;

        Set<SleepingQueenPosition> sleepingQueenPositions = new HashSet<>();
        Map<Position, Queen> sleepingQueensMap = sleepingQueens.getQueens();
        sleepingQueensMap.forEach((position, queen) -> {
            if(position.getSleepingQueenPosition().isPresent()){
                SleepingQueenPosition sQP = position.getSleepingQueenPosition().get();
                sleepingQueenPositions.add(sQP);
            }
        });
        gameState.sleepingQueens = sleepingQueenPositions;

        Map<HandPosition, Optional<Card>> cardsMap = new HashMap<>();
        playerList.forEach(player -> {
            List<Card> playersCards = player.getPlayersCards();
           for(int i=0; i<playersCards.size(); i++){
               HandPosition handPosition = new HandPosition(i, player.getPlayerIdx());
               cardsMap.put(handPosition, Optional.of(playersCards.get(i)));
           }
        });
        gameState.cards = cardsMap;

        Map<AwokenQueenPosition, Queen> awokenQueenPositions = new HashMap<>();
        playerList.forEach(player -> {
            AwokenQueens aQPlayer = player.getAwokenQueens();
            Map<Position, Queen> awokenQueensMap = aQPlayer.getQueens();
            awokenQueensMap.forEach((position, queen) -> {
                if(position.getAwokenQueenPosition().isPresent()){
                    AwokenQueenPosition aQP = position.getAwokenQueenPosition().get();
                    awokenQueenPositions.put(aQP, queen);
                }
            });
        });

        gameState.awokenQueens = awokenQueenPositions;

        // nie som si tymto ista
        gameState.cardsDiscardedLastTurn = dAndTPile.getCardsDiscardedThisTurn();


        return Optional.of(gameState);
    }    

    public List<Player> getPlayersList(){
        return playerList;
    }
    public void setPlayerList(List<Player> playerList){
        this.playerList = playerList;
    }

    public int playerOnTurn(){
        return onTurn;
    }
    public SleepingQueens getSleepingQueens(){
        return sleepingQueens;
    }

    public DrawingAndTrashPile getdrawingAndTrashPile() {
        return dAndTPile;
    }
}
