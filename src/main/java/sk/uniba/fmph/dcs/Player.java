package sk.uniba.fmph.dcs;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class Player {

    private int playerIdx;
    private Hand playersHand;
    private AwokenQueens awokenQueens;
    private Game game;

    public Player(){
        playersHand = new Hand(playerIdx);
    }

    public void play(List<Position> cards){}

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

    public AwokenQueens getPlayersAwokenQueens(){
        return awokenQueens;
    }
}