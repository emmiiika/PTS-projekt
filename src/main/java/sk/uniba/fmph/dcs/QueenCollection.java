package sk.uniba.fmph.dcs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface QueenCollection {
    public void addQueen(Queen queen);
    public Optional<Queen> removeQueen(SleepingQueenPosition position);
    public Map<Position, Queen> getQueens();
}
