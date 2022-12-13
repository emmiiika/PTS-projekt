package sk.uniba.fmph.dcs;

import java.util.*;

public class SleepingQueens extends QueenCollection {

    public SleepingQueens(Random random) {
        super();
        queens = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            Queen queen = new Queen(5);
            queens.add(queen);
            queen = new Queen(10);
            queens.add(queen);

            if (i == 0) {
                queen = new Queen(20);
                queens.add(queen);
            } else {
                queen = new Queen(15);
                queens.add(queen);
            }
        }

        Collections.shuffle(queens, random);
    }

    @Override
    public Map<Position, Queen> getQueens() {

        Map<Position, Queen> queensPositions = new HashMap<>();

        for (int i = 0; i < queens.size(); i++) {
            Position position = new SleepingQueenPosition(i);
            queensPositions.put(position, queens.get(i));
        }
        return queensPositions;
    }
}
