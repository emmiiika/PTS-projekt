package sk.uniba.fmph.dcs;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Player {

    private int playerIdx;
    private Hand playersHand;
    private AwokenQueens awokenQueens;
    private Game game;

    public Player(int playerIdx, Game game){
        this.playerIdx = playerIdx;
        this.playersHand = new Hand(playerIdx, game.getdrawingAndTrashPile());
        this.game = game;
    }

    public void play(List<HandPosition> cards){
        Optional<List<Card>> pickedCards = playersHand.pickCards(cards);

        if(pickedCards.isPresent()){
            List<Card> pickedCardsList = pickedCards.get();
            if(playersHand.areAllNumbered(pickedCardsList)){
                EvaluateNumberedCards evaluateNumberedCards = new EvaluateNumberedCards();
                boolean success = evaluateNumberedCards.play(pickedCardsList);

                if(success){
                        playersHand.removePickedCardsAndRedraw();
                }
                else {
                    playersHand.returnPickedCards();
                }
            } else if (pickedCards.get().get(0).type == CardType.KING) {
                SleepingQueens sleepingQueens = game.getSleepingQueens();
            } else{
                DrawingAndTrashPile drawingAndTrashPile = game.getdrawingAndTrashPile();
                drawingAndTrashPile.discardAndDraw(pickedCardsList);
                EvaluateAttack evaluateAttack = new EvaluateAttack(game);
            }
        }
    }

    public PlayerState getPlayerState(){
        List<Card> cards = playersHand.getCards();
        Map<Integer, Optional<Card>> cardsMap = new HashMap<>();
        for(int i=0; i<cards.size(); i++){
            cardsMap.put(i, Optional.of(cards.get(i)));
        }

        // neviem ci a ako to funguje ale povedzme
        Map<Position, Queen> queens = awokenQueens.getQueens();
        Map<Integer,Queen> awokenQueensMap = new HashMap<>();
        Object[] keys = queens.keySet().toArray();
        
        for(int i=0; i<queens.size(); i++){
            awokenQueensMap.put(i, queens.get(keys[i]));
        }

        return new PlayerState(cardsMap, awokenQueensMap);
    }

    public List<Card> getPlayersCards(){
        return playersHand.getCards();
    }
    public int getPlayerIdx(){
        return playerIdx;
    }

    public AwokenQueens getAwokenQueens() {
        return awokenQueens;
    }

    public void setAwokenQueens(AwokenQueens awokenQueens) {
        this.awokenQueens = awokenQueens;
    }
}