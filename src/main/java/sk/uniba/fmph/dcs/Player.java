package sk.uniba.fmph.dcs;

import java.util.*;

public class Player implements GameObserver {

    private int playerIdx;
    private Hand playersHand;
    private AwokenQueens awokenQueens;
    private Game game;

    public Player(int playerIdx, Game game) {
        this.playerIdx = playerIdx;
        this.playersHand = new Hand(playerIdx, game.getdrawingAndTrashPile());
        this.awokenQueens = new AwokenQueens(playerIdx);
        this.game = game;
    }

    public void play(List<Position> cards) {
        Optional<List<Card>> pickedCards = playersHand.pickCards(cards);
        System.out.println(pickedCards.isPresent());
        if (pickedCards.isPresent()) {
            List<Card> pickedCardsList = pickedCards.get();
            System.out.println(pickedCardsList.get(0).value);
            // picked cards are all nums
            if (playersHand.areAllNumbered(pickedCardsList)) {
                EvaluateNumberedCards evaluateNumberedCards = new EvaluateNumberedCards();
                boolean success = evaluateNumberedCards.play(pickedCardsList);

                if (success) {
                    playersHand.removePickedCardsAndRedraw();
                } else {
                    playersHand.returnPickedCards();
                }
            }
            // picked card is KING
            else if (pickedCards.get().get(0).type == CardType.KING) {
                SleepingQueens sleepingQueens = game.getSleepingQueens();
                Map<Position, Queen> sq = sleepingQueens.getQueens();
                Position sleepingQueenPosition = sq.keySet().iterator().next();

                if (sleepingQueenPosition != null) {
                    Optional<Queen> awokenQueen = sleepingQueens.removeQueen(new SleepingQueenPosition(sleepingQueenPosition.getCardIndex()));
                    awokenQueen.ifPresent(queen -> awokenQueens.addQueen(queen));
                }
            }
            // picked card is KNIGHT OR SLEEPINGPOTION
            else {
                for(Position cardPosition: cards){
                    if(cardPosition instanceof AwokenQueenPosition){
                        DrawingAndTrashPile drawingAndTrashPile = game.getdrawingAndTrashPile();
                        drawingAndTrashPile.discardAndDraw(pickedCardsList);
                        EvaluateAttack evaluateAttack = new EvaluateAttack(game, pickedCards.get().get(0).type);
                        evaluateAttack.play(cardPosition);
                    }
                }
            }
        }
    }

    public PlayerState getPlayerState() {
        List<Card> cards = playersHand.getCards();
        Map<Integer, Optional<Card>> cardsMap = new HashMap<>();
        for (int i = 0; i < cards.size(); i++) {
            cardsMap.put(i, Optional.of(cards.get(i)));
        }

        Map<Position, Queen> queens = awokenQueens.getQueens();
        Map<Integer, Queen> awokenQueensMap = new HashMap<>();
        Set<Position> keys = queens.keySet();

        int i = 0;
        for (Position position : keys) {
            awokenQueensMap.put(i++, queens.get(position));
        }

        return new PlayerState(cardsMap, awokenQueensMap);
    }

    public List<Card> getPlayersCards() {
        return playersHand.getCards();
    }

    public int getPlayerIdx() {
        return playerIdx;
    }

    public AwokenQueens getAwokenQueens() {
        return awokenQueens;
    }

    public void setAwokenQueens(AwokenQueens awokenQueens) {
        this.awokenQueens = awokenQueens;
    }

    @Override
    public void notify(GameState message) {
        if (message.onTurn == playerIdx) {
        }
    }
}