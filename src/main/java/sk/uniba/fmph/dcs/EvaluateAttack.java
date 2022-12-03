package sk.uniba.fmph.dcs;

import java.util.List;

public class EvaluateAttack {
    private CardType defenseCardType;

    private Game game;
    private int attacker;
    private int defender;

    public EvaluateAttack(Game game){
        this.game = game;
        this.attacker = game.playerOnTurn();
    }

    public boolean play(Position targetQueen, int targetPlayerIdx){
        this.defender = targetPlayerIdx;
        List<Card> playersCards = game.getPlayersList().get(targetPlayerIdx).getPlayersCards();
        
        for(Card card: playersCards){
            if(card.type == defenseCardType){
                // neuspesny attack
                return false;
            }
        }
        
        // uspesny attack
        MoveQueen moveQueen = new MoveQueen(defenseCardType, attacker, defender);
        moveQueen.play(targetQueen);
        return true;
    }
}
