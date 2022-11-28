package sk.uniba.fmph.dcs;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Hand {

    private int playerIdx;

    public Hand(){}
    
    public Optional<List<Card>> pickCards(List<HandPosition> positions){
        return null;
    }

    public Map<HandPosition, Card> removePickedCardsAndRedraw(){
        return null;
    }
    
    public void returnPickedCards(){}

    public HandPosition hasCardOfType(CardType type){
        return null;
    }

    public List<Card> getCards(){
        return null;
    }

}
