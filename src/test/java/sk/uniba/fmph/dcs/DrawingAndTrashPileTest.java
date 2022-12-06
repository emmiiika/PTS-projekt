package sk.uniba.fmph.dcs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DrawingAndTrashPileTest {

    private List<Card> cards;
    private DrawingAndTrashPile drawingAndTrashPile;
    private List<Card> discard;

    @Test
    void discardAndDraw() {
        assertEquals(3, cards.size());
    }

    @Test
    void getCardsDiscardedThisTurn() {
        List<Card> discardedCards = drawingAndTrashPile.getCardsDiscardedThisTurn();
        assertEquals(discard.get(0), discardedCards.get(0));
        assertEquals(discard.get(1), discardedCards.get(1));
        assertEquals(discard.get(2), discardedCards.get(2));
    }

    @BeforeEach
    void setUp() {
        drawingAndTrashPile = new DrawingAndTrashPile();
        discard = new ArrayList<>();
        discard.add(new Card(CardType.NUMBER, 1));
        discard.add(new Card(CardType.NUMBER, 2));
        discard.add(new Card(CardType.NUMBER, 3));

        cards = drawingAndTrashPile.discardAndDraw(discard);
    }
}