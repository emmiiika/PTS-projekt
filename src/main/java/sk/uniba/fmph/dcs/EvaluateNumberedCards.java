package sk.uniba.fmph.dcs;

import java.util.List;

public class EvaluateNumberedCards {
    public boolean play(List<Card> cards){
        int n = cards.size();
        if(n == 1){
            return true;
        }
        else if(n == 2){
            return cards.get(0) == cards.get(1);
        }
        else {
            Card cardWithGreatestValue = new Card(CardType.NUMBER, 1);
            for (Card card : cards) {
                if (card.value > cardWithGreatestValue.value) {
                    cardWithGreatestValue = card;
                }
            }
            int sum = 0;
            for (Card card : cards) {
                if (!card.equals(cardWithGreatestValue)) {
                    sum += card.value;
                }
            }
            return sum == cardWithGreatestValue.value;
        }
    }
}
