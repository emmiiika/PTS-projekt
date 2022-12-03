package sk.uniba.fmph.dcs;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Player {

    private Hand playersHand;
    private AwokenQueens awokenQueens;
    private Game game;

    public Player(){
        playersHand = new Hand();
    }

    public void play(List<Position> cards){}

    public PlayerState getPlayerState(){
        List<Card> cards = playersHand.getCards();
        Map<Integer, Optional<Card>> cardsMap = new HashMap<>();
        for(int i=0; i<cards.size(); i++){
            cardsMap.put(i, Optional.of(cards.get(i)));
        }

        // Map<Position, Queen> queens = awokenQueens.getQueens();
        // Map<Integer,Queen> awokenQueensMap = new HashMap<>();
        // for(int i=0; i<awokenQueens.getCount(); i++){
        //     awokenQueensMap.put(i, awokenQueens.getClass()
        // }

        return new PlayerState(cardsMap, null);
    }

    public List<Card> getPlayersCards(){
        return playersHand.getCards();
    }

    public AwokenQueens getPlayersAwokenQueens(){
        return awokenQueens;
    }
}