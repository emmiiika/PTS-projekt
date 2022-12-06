package sk.uniba.fmph.dcs;

import java.util.ArrayList;
import java.util.List;

public class EvaluateAttack {
    private CardType defenseCardType;

    private Game game;
    private int attacker;
    private int defender;
    private List<Player> players;

    public EvaluateAttack(Game game){
        this.game = game;
        this.attacker = game.playerOnTurn();
        this.players = game.getPlayersList();
    }

    public boolean play(Position targetQueen, int targetPlayerIdx){
        this.defender = targetPlayerIdx;
        List<Card> playersCards = game.getPlayersList().get(targetPlayerIdx).getPlayersCards();
        
        for(Card card: playersCards){
            if(card.type == defenseCardType){
                // neuspesny attack
                DrawingAndTrashPile drawingAndTrashPile = game.getdrawingAndTrashPile();
                List<Card> discard = new ArrayList<>();
                discard.add(card);
                drawingAndTrashPile.discardAndDraw(discard);
                return false;
            }
        }

        AwokenQueens attackersAwokenQueens = players.get(attacker).getAwokenQueens();
        AwokenQueens defendersAwokenQueens = players.get(defender).getAwokenQueens();
        // uspesny attack
        MoveQueen moveQueen = new MoveQueen(defenseCardType, attackersAwokenQueens, defendersAwokenQueens, game.getSleepingQueens());
        moveQueen.play(targetQueen);
        return true;
    }
}
