package sk.uniba.fmph.dcs;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EvaluateNumberedCardsTest {

    @Test
    void play() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(CardType.NUMBER, 1));
        cards.add(new Card(CardType.NUMBER, 2));
        cards.add(new Card(CardType.NUMBER, 3));

        EvaluateNumberedCards evaluateNumberedCards = new EvaluateNumberedCards();
        assertTrue(evaluateNumberedCards.play(cards));

        cards.add(new Card(CardType.NUMBER, 4));
        assertFalse(evaluateNumberedCards.play(cards));

    }
}