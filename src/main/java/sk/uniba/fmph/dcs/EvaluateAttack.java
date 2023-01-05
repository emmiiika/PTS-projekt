package sk.uniba.fmph.dcs;

import java.util.ArrayList;
import java.util.List;

public class EvaluateAttack {
    private final Game game;
    private final int attacker;
    private final List<Player> players;
    private CardType defenseCardType;

    public EvaluateAttack(Game game, CardType attackCardType) {
        this.game = game;
        this.attacker = game.playerOnTurn();
        this.players = game.getPlayersList();
        switch (attackCardType) {
            case KNIGHT:
                this.defenseCardType = CardType.DRAGON;
                break;
            case SLEEPINGPOTION:
                this.defenseCardType = CardType.MAGICWAND;
                break;
        }
    }

    public boolean play(Position targetQueen) {
        int targetPlayerIdx = targetQueen.getPlayerIndex();
        List<Card> playersCards = game.getPlayersList().get(targetPlayerIdx).getPlayersCards();

        for (Card card : playersCards) {
            if (card.type == defenseCardType) {
                // neuspesny attack
                DrawingAndTrashPile drawingAndTrashPile = game.getdrawingAndTrashPile();
                List<Card> discard = new ArrayList<>();
                discard.add(card);
                drawingAndTrashPile.discardAndDraw(discard);
                return false;
            }
        }

        AwokenQueens attackersAwokenQueens = players.get(attacker).getAwokenQueens();
        AwokenQueens defendersAwokenQueens = players.get(targetPlayerIdx).getAwokenQueens();
        // uspesny attack
        MoveQueen moveQueen = new MoveQueen(defenseCardType, attackersAwokenQueens, defendersAwokenQueens, game.getSleepingQueens());
        moveQueen.play(targetQueen);
        return true;
    }
}
