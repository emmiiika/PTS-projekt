package sk.uniba.fmph.dcs;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PileDrawRemaining pileDrawRemaining = new PileDrawRemaining();
        GameAdaptor gameAdaptor = new GameAdaptor(pileDrawRemaining);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Who's gonna start?");
        String player = scanner.nextLine();

        while (gameAdaptor.isFinished().isEmpty()) {
            List<Card> cards = gameAdaptor.getPlayersCards();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Your cards: ");
            for (int i = 0; i < cards.size(); i++) {
                Card card = cards.get(i);
                stringBuilder.append(i).append(": ");
                stringBuilder.append(card.type).append("(");
                stringBuilder.append(card.value).append(")");
                stringBuilder.append(", ");
            }
            stringBuilder.append("\n");
            System.out.println(stringBuilder);

            System.out.println("What do you want to play?");
            String karty = scanner.nextLine();

            System.out.println(gameAdaptor.play(player, karty));
        }
    }
}
