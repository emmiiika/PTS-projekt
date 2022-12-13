package sk.uniba.fmph.dcs;

import java.util.*;

public class PileDrawRemaining implements DrawingPileType {
    @Override
    public List<Card> deal(DrawingAndTrashPile drawingAndTrashPile, Random random, List<Card> discard) {
        List<Card> cards = new ArrayList<>();
        int numberOfCards = discard.size();

        drawingAndTrashPile.getTrashPile().addAll(discard);


        while (drawingAndTrashPile.getRemainingCardsCount() > 0) {
            cards.add(drawingAndTrashPile.drawOne());
            numberOfCards--;
        }
        if (numberOfCards > 0) {
            Collections.shuffle(drawingAndTrashPile.getTrashPile(), random);
            drawingAndTrashPile.setDrawPile(drawingAndTrashPile.getTrashPile());
            drawingAndTrashPile.setTrashPile(new Stack<>());

            while (numberOfCards > 0) {
                cards.add(drawingAndTrashPile.drawOne());
                numberOfCards--;
            }
        }
        return cards;
    }
}
