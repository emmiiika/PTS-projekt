package sk.uniba.fmph.dcs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class PileDrawRemaining implements DrawingPileType{
    @Override
    public List<Card> deal(DrawingAndTrashPile drawingAndTrashPile, List<Card> discard) {
        List<Card> cards = new ArrayList<>();
        int numberOfCards = discard.size();
        drawingAndTrashPile.getTrashPile().addAll(discard);
        while(drawingAndTrashPile.getRemainingCardsCount() > 0){
            cards.add(drawingAndTrashPile.drawOne());
            numberOfCards--;
        }
        if(numberOfCards > 0){
            Collections.shuffle(drawingAndTrashPile.getTrashPile()); // REVIEW: this is not deterministic, how can you test it?
            drawingAndTrashPile.setDrawPile(drawingAndTrashPile.getTrashPile());
            drawingAndTrashPile.setTrashPile(new Stack<>());

            while(numberOfCards > 0){
                cards.add(drawingAndTrashPile.drawOne());
                numberOfCards--;
            }
        }
        return cards;
    }
}
