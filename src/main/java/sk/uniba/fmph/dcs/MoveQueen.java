package sk.uniba.fmph.dcs;

import java.util.Optional;

public class MoveQueen{

    private int attackerIdx;
    private int defenderIdx;
    private CardType actionBasedOf;
    private AwokenQueens awokenQueens;
    private SleepingQueens sleepingQueens;

    public MoveQueen(CardType defenseCardType, int attackerIdx, int defenderIdx, AwokenQueens awokenQueens, SleepingQueens sleepingQueens ){
        this.attackerIdx = attackerIdx;
        this.defenderIdx = defenderIdx;
        this.actionBasedOf = defenseCardType;
        this.awokenQueens = awokenQueens;
        this.sleepingQueens = sleepingQueens;
    }
    
    public boolean play(Position targetQueen){
        switch(actionBasedOf){
            case DRAGON:
                if (targetQueen.getAwokenQueenPosition().isPresent()) {
                    AwokenQueenPosition cardIndex = targetQueen.getAwokenQueenPosition().get();

                }

                return false;
        
            case MAGICWAND:
                return true;
            
            default:
                break;
        }
        return false;
    }
}


