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
    private DrawingAndTrashPile drawingAndTrashPile;

    public Hand(int playerIdx, DrawingAndTrashPile drawingAndTrashPile){
        this.playerIdx = playerIdx;
        this.cardsOnHand = drawingAndTrashPile.dealCards();
        this.pickedCards = new ArrayList<>();
        this.drawingAndTrashPile = drawingAndTrashPile;
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
        cardsOnHand.removeAll(pickedCards);
        int n = pickedCards.size();

        List<Card> newCards = drawingAndTrashPile.discardAndDraw(pickedCards);
        cardsOnHand.addAll(newCards);

        Map<HandPosition, Card> cardOnPosition = new HashMap<>();
        for(int i=0; i<n; i++){
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

    public boolean areAllNumbered(List<Card> cards){
        for(Card card: cards){
            if(card.type != CardType.NUMBER){
                return false;
            }
        }
        return true;
    }

}
