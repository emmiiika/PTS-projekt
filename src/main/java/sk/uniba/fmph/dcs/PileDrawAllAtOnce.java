package sk.uniba.fmph.dcs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class PileDrawAllAtOnce implements DrawingPileType{
    @Override
    public List<Card> deal(DrawingAndTrashPile drawingAndTrashPile, List<Card> discard) {
        List<Card> cards = new ArrayList<>();
        int numberOfCards = discard.size();
        if(drawingAndTrashPile.getRemainingCardsCount() < numberOfCards){
            List<Card> remainingCards = new ArrayList<>();

            Collections.shuffle(drawingAndTrashPile.getTrashPile()); // REVIEW: this is not deterministic, how can you test it?
            drawingAndTrashPile.setDrawPile(drawingAndTrashPile.getTrashPile());
            drawingAndTrashPile.setTrashPile(new Stack<>());

            drawingAndTrashPile.getDrawPile().addAll(remainingCards);
            drawingAndTrashPile.getTrashPile().addAll(discard);

            while (numberOfCards > 0){
                cards.add(drawingAndTrashPile.drawOne());
                numberOfCards--;
            }
        }
        return cards;
    }
}
