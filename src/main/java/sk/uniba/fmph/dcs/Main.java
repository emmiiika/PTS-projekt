package sk.uniba.fmph.dcs;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PileDrawRemaining pileDrawRemaining = new PileDrawRemaining();
        GameAdaptor gameAdaptor = new GameAdaptor(pileDrawRemaining);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Who's gonna start?");
        String player = scanner.nextLine();

        while (gameAdaptor.isFinished().isEmpty()) {
            System.out.println("What do you want to play?");
            String cards = scanner.nextLine();

            System.out.println(gameAdaptor.play(player, cards));
        }
    }
}
