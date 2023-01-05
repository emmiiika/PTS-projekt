package sk.uniba.fmph.dcs;

import java.util.*;

public class Game {

    private final DrawingAndTrashPile dAndTPile;
    private List<Player> playerList;
    private SleepingQueens sleepingQueens;
    private int onTurn;

    public Game(DrawingAndTrashPile dAndTPile) {
        this.playerList = new ArrayList<>();
        this.dAndTPile = dAndTPile;
        this.sleepingQueens = new SleepingQueens(new Random());
        this.onTurn = 0;
    }

    public Optional<GameState> play(int playerIdx, List<Position> cards) {
        GameState gameState = new GameState();
        gameState.numberOfPlayers = playerList.size();
//        gameState.onTurn = playerIdx;

        Set<SleepingQueenPosition> sleepingQueenPositions = new HashSet<>();
        Map<Position, Queen> sleepingQueensMap = sleepingQueens.getQueens();
        sleepingQueensMap.forEach((position, queen) -> {
            SleepingQueenPosition sQP = new SleepingQueenPosition(position.getCardIndex());
            sleepingQueenPositions.add(sQP);
        });
        gameState.sleepingQueens = sleepingQueenPositions;

        Map<HandPosition, Optional<Card>> cardsMap = new HashMap<>();
        Player player = playerList.get(playerIdx);
        player.play(cards);

        List<Card> playersCards = player.getPlayersCards();
        for (int i = 0; i < playersCards.size(); i++) {
            HandPosition handPosition = new HandPosition(i, player.getPlayerIdx());
            cardsMap.put(handPosition, Optional.of(playersCards.get(i)));
        }
        gameState.cards = cardsMap;

        Map<AwokenQueenPosition, Queen> awokenQueenPositions = new HashMap<>();
        AwokenQueens aQPlayer = player.getAwokenQueens();
        Map<Position, Queen> awokenQueensMap = aQPlayer.getQueens();
        awokenQueensMap.forEach((position, queen) -> awokenQueenPositions.put((AwokenQueenPosition) position, queen));

        gameState.awokenQueens = awokenQueenPositions;
        gameState.cardsDiscardedLastTurn = dAndTPile.getCardsDiscardedThisTurn();


        this.onTurn = (this.onTurn + 1) % getPlayersList().size();
        return Optional.of(gameState);
    }

    public List<Player> getPlayersList() {
        return playerList;
    }

    public void setPlayerList(List<Player> playerList) {
        this.playerList = playerList;
    }

    public int playerOnTurn() {
        return onTurn;
    }

    public SleepingQueens getSleepingQueens() {
        return sleepingQueens;
    }

    public DrawingAndTrashPile getdrawingAndTrashPile() {
        return dAndTPile;
    }

    public Optional<Integer> isFinished(GameFinishedStrategy gameFinishedStrategy) {
        return gameFinishedStrategy.isFinished();
    }
}
