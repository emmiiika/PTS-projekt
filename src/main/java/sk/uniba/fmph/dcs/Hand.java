package sk.uniba.fmph.dcs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Hand {

    private int playerIdx;

    private List<Card> cardsOnHand;
    private List<Card> pickedCards;

    public Hand(int playerIdx){
        this.playerIdx = playerIdx;
        cardsOnHand = new ArrayList<>();
        pickedCards = new ArrayList<>();
    }
    
    public Optional<List<Card>> pickCards(List<HandPosition> positions){
        for(HandPosition position: positions){
            if(position.getPlayerIndex() == playerIdx && position.getCardIndex() < cardsOnHand.size()){
                pickedCards.add(cardsOnHand.get(position.getCardIndex()));                
            }
            else{
                return Optional.empty();
            }
        }
        return Optional.of(pickedCards);
    }

    public Map<HandPosition, Card> removePickedCardsAndRedraw(){
        DrawingAndTrashPile drawingAndTrashPile = new DrawingAndTrashPile();
        
        cardsOnHand.removeAll(pickedCards);

        List<Card> newCards = drawingAndTrashPile.discardAndDraw(pickedCards);
        cardsOnHand.addAll(newCards);

        Map<HandPosition, Card> cardOnPosition = new HashMap<>();
        for(int i=0; i<cardsOnHand.size(); i++){
            HandPosition handPosition = new HandPosition(i, playerIdx);
            cardOnPosition.put(handPosition, cardsOnHand.get(i));
        }

        return cardOnPosition;
    }
    
    public void returnPickedCards(){
        pickedCards = new ArrayList<>();
    }

    public HandPosition hasCardOfType(CardType type){
        int cardIndex = -1;
        
        for(int i=0; i<cardsOnHand.size(); i++){
            if(cardsOnHand.get(i).type == type){
                cardIndex = i;
                break;
            }
       }

       HandPosition handPosition = new HandPosition(cardIndex, playerIdx);
       return handPosition;
    }

    public List<Card> getCards(){
        return cardsOnHand;
    }

    public int getPlayerIndex(){
        return playerIdx;
    }

}
