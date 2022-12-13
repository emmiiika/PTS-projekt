package sk.uniba.fmph.dcs;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public abstract class QueenCollection {

    List<Queen> queens;

    public void addQueen(Queen queen) {
        queens.add(queen);
    }

    ;

    public Optional<Queen> removeQueen(Position position) {
        return Optional.ofNullable(queens.remove(position.getCardIndex()));
    }

    ;

    public abstract Map<Position, Queen> getQueens();
}
