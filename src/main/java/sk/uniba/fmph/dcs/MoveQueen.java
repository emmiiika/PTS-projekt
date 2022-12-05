package sk.uniba.fmph.dcs;

import java.util.Optional;

public class MoveQueen{
    private CardType actionBasedOf;
    private AwokenQueens attackersAwokenQueens;
    private AwokenQueens defendersAwokenQueens;
    private SleepingQueens sleepingQueens;

    public MoveQueen(CardType defenseCardType, AwokenQueens atttackersAwokenQueens, AwokenQueens defendersAwokenQueens, SleepingQueens sleepingQueens ){
        this.actionBasedOf = defenseCardType;
        this.attackersAwokenQueens = atttackersAwokenQueens;
        this.defendersAwokenQueens = defendersAwokenQueens;
        this.sleepingQueens = sleepingQueens;
    }
    
    public boolean play(Position targetQueen) {
        switch (actionBasedOf) {
            case DRAGON:
                if (targetQueen.getAwokenQueenPosition().isPresent()) {
                    AwokenQueenPosition targetQueenPosition = targetQueen.getAwokenQueenPosition().get();
                    Optional<Queen> queen = defendersAwokenQueens.removeQueen(targetQueenPosition);
                    if (queen.isPresent()) {
                        attackersAwokenQueens.addQueen(queen.get());
                        return true;
                    }
                }
                return false;

            case MAGICWAND:
                if (targetQueen.getAwokenQueenPosition().isPresent()) {
                    AwokenQueenPosition targetQueenPosition = targetQueen.getAwokenQueenPosition().get();
                    Optional<Queen> queen = defendersAwokenQueens.removeQueen(targetQueenPosition);
                    if (queen.isPresent()) {
                        sleepingQueens.addQueen(queen.get());
                        return true;
                    }
                }
                return false;

            default:
                return false;
        }
    }
}


