package sk.uniba.fmph.dcs;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AwokenQueens extends QueenCollection {
    private final int playerIdx;

    public AwokenQueens(int playerIdx) {
        super();
        queens = new ArrayList<>();
        this.playerIdx = playerIdx;
    }

    @Override
    public Map<Position, Queen> getQueens() {
        Map<Position, Queen> queensPositions = new HashMap<>();

        for (int i = 0; i < queens.size(); i++) {
            Position position = new AwokenQueenPosition(i, playerIdx);
            queensPositions.put(position, queens.get(i));
        }
        return queensPositions;
    }
}
