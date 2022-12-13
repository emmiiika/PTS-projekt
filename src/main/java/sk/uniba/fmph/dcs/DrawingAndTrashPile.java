package sk.uniba.fmph.dcs;

import java.util.*;

public class DrawingAndTrashPile {

    private final DrawingPileType drawingPileType;
    private final Random random;
    private Stack<Card> trashPile;
    private Stack<Card> drawPile;
    private List<Card> discardedCardsInTurn;

    public DrawingAndTrashPile(DrawingPileType drawingPileType, Random random) {
        this.trashPile = new Stack<>();
        this.drawPile = new Stack<>();
        this.drawingPileType = drawingPileType;
        this.random = random;

        Map<CardType, Integer> cardCounts = new HashMap<>();
        cardCounts.put(CardType.KING, 8);
        cardCounts.put(CardType.KNIGHT, 4);
        cardCounts.put(CardType.SLEEPINGPOTION, 4);
        cardCounts.put(CardType.MAGICWAND, 3);
        cardCounts.put(CardType.DRAGON, 3);

        List<Card> allCards = new ArrayList<>();
        cardCounts.forEach((cardType, integer) -> {
            for (int i = 0; i < integer; i++) {
                allCards.add(new Card(cardType, 0));
            }
        });
        for (int i = 1; i < 11; i++) {
            for (int j = 0; j < 4; j++) {
                allCards.add(new Card(CardType.NUMBER, i));
            }
        }

        Collections.shuffle(allCards, random);
        drawPile.addAll(allCards);


        this.discardedCardsInTurn = new ArrayList<>();
    }

    public List<Card> discardAndDraw(List<Card> discard) {
        return drawingPileType.deal(this, random, discard);
    }

    public void newTurn() {
        discardedCardsInTurn = new ArrayList<>();
    }

    public List<Card> getCardsDiscardedThisTurn() {
        return discardedCardsInTurn;
    }

    public List<Card> dealCards() {
        List<Card> cards = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            cards.add(drawPile.pop());
        }
        return cards;
    }

    public int getRemainingCardsCount() {
        return drawPile.size();
    }

    public Card drawOne() {
        return drawPile.pop();
    }

    public Stack<Card> getDrawPile() {
        return drawPile;
    }

    public void setDrawPile(Stack<Card> drawPile) {
        this.drawPile = drawPile;
    }

    public Stack<Card> getTrashPile() {
        return trashPile;
    }

    public void setTrashPile(Stack<Card> trashPile) {
        this.trashPile = trashPile;
    }
}