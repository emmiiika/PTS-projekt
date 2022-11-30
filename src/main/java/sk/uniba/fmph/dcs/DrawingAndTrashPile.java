package sk.uniba.fmph.dcs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DrawingAndTrashPile {

    private Stack<Card> trashPile;
    private Stack<Card> drawPile;

    private List<Card> discardedCardsInTurn;
 
    public DrawingAndTrashPile(){
        this.trashPile = new Stack<>();
        this.drawPile = new Stack<>();

        discardedCardsInTurn = new ArrayList<>();
    }

    public List<Card> discardAndDraw(List<Card> discard){
        trashPile.addAll(discard);
        discardedCardsInTurn.addAll(discard);

        List<Card> cards = new ArrayList<>();
        int n = discard.size();
        for(int i=0; i<n; i++){
            cards.add(drawPile.pop());
        }

        return cards;
    }

    public void newTurn(){
        discardedCardsInTurn = new ArrayList<>();
    }

    public List<Card> getCardsDiscardedThisTurn(){
        return discardedCardsInTurn;
    }
}