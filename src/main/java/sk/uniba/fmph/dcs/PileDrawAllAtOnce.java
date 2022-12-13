package sk.uniba.fmph.dcs;

import java.util.*;

public class PileDrawAllAtOnce implements DrawingPileType {
    @Override
    public List<Card> deal(DrawingAndTrashPile drawingAndTrashPile, Random random, List<Card> discard) {
        List<Card> cards = new ArrayList<>();
        int numberOfCards = discard.size();

        if (drawingAndTrashPile.getRemainingCardsCount() < numberOfCards) {
            List<Card> remainingCards = new ArrayList<>();

            Collections.shuffle(drawingAndTrashPile.getTrashPile(), random);
            drawingAndTrashPile.setDrawPile(drawingAndTrashPile.getTrashPile());
            drawingAndTrashPile.setTrashPile(new Stack<>());

            drawingAndTrashPile.getDrawPile().addAll(remainingCards);
            drawingAndTrashPile.getTrashPile().addAll(discard);

            while (numberOfCards > 0) {
                cards.add(drawingAndTrashPile.drawOne());
                numberOfCards--;
            }
        } else {
            cards.add(drawingAndTrashPile.drawOne());
            cards.addAll(deal(drawingAndTrashPile, random, discard));
        }
        return cards;
    }
}
