package sk.uniba.fmph.dcs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class HandTest {

    DrawingAndTrashPile drawingAndTrashPile;
    Hand hand;
    List<HandPosition> positions;
    HandPosition handPosition;

    @Test
    void pickCards() {
        Optional<List<Card>> pickedCards = hand.pickCards(positions);
        assertTrue(pickedCards.isPresent());
        assertEquals(hand.getCards().get(positions.get(0).getCardIndex()), pickedCards.get().get(0));
    }

    @Test
    void removePickedCardsAndRedraw() {
        Optional<List<Card>> pickedCards = hand.pickCards(positions);
        Map<HandPosition, Card> redrawedCards = hand.removePickedCardsAndRedraw();

        assertTrue(pickedCards.isPresent());
        assertEquals(pickedCards.get().size(), redrawedCards.size());
    }

    // PRE SPUSTANIE TOHTO TESTU TREBA ZAKOMENTOVAT SHUFFLE V DrawingAndTrashPile
//    @Test
//    void hasCardOfType() {
//        List<Card> cards = hand.getCards();
////        for(int i=0; i<cards.size(); i++){
////            System.out.println(cards.get(i).type + " " + cards.get(i).value);
////        }
//        HandPosition handPosition1 = new HandPosition(0, 0);
//        assertEquals(handPosition1.getCardIndex(), hand.hasCardOfType(CardType.NUMBER).getCardIndex());
//        HandPosition handPosition2 = new HandPosition(-1, 0);
//        assertEquals(handPosition2.getCardIndex(), hand.hasCardOfType(CardType.MAGICWAND).getCardIndex());
//    }

    // PRE SPUSTANIE TOHTO TESTU TREBA ZAKOMENTOVAT SHUFFLE V DrawingAndTrashPile
//    @Test
//    void getCards() {
//        List<Card> cards = hand.getCards();
////        for(int i=0; i<cards.size(); i++){
////            System.out.println(cards.get(i).type + " " + cards.get(i).value);
////        }
//        List<Card> cardList = new ArrayList<>();
//        cardList.add(new Card(CardType.NUMBER, 10));
//        cardList.add(new Card(CardType.NUMBER, 10));
//        cardList.add(new Card(CardType.NUMBER, 10));
//        cardList.add(new Card(CardType.NUMBER, 10));
//        cardList.add(new Card(CardType.NUMBER, 9));
//
//        for(int i=0; i<5; i++){
//            assertEquals(cardList.get(i).type,cards.get(i).type);
//            assertEquals(cardList.get(i).value,cards.get(i).value);
//        }
//    }

    @Test
    void areAllNumbered() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(CardType.NUMBER, 5));
        cards.add(new Card(CardType.NUMBER, 3));
        assertTrue(hand.areAllNumbered(cards));
    }

    @BeforeEach
    void setUp() {
        drawingAndTrashPile = new DrawingAndTrashPile();
        hand = new Hand(0, drawingAndTrashPile);
        positions = new ArrayList<>();
        handPosition = new HandPosition(0,0);
        positions.add(handPosition);
    }
}