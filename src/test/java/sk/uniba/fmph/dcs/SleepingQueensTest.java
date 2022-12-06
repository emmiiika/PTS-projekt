package sk.uniba.fmph.dcs;

import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class SleepingQueensTest {

    @Test
    void addQueen() {
        SleepingQueens sq = new SleepingQueens();
        Queen q = new Queen(10);
        sq.addQueen(q);
        Map<Position, Queen> queens = sq.getQueens();
        Queen queen = queens.get(queens.keySet().iterator().next());

        assertEquals(1, queens.size());
        assertEquals(q, queen);

    }

    @Test
    void removeQueen() {
        SleepingQueens sq = new SleepingQueens();
        Queen q = new Queen(10);
        sq.addQueen(q);
        Map<Position, Queen> queens = sq.getQueens();
        Position position = queens.keySet().iterator().next();

        assertTrue(position.getSleepingQueenPosition().isPresent());
        assertTrue(position.getAwokenQueenPosition().isEmpty());

        SleepingQueenPosition sleepingQueenPosition = position.getSleepingQueenPosition().get();
        Optional<Queen> queen = sq.removeQueen(sleepingQueenPosition);
        assertTrue(queen.isPresent());
        assertEquals(q, queen.get());
    }

    @Test
    void removeQueenNotInAQ() {
        SleepingQueens sq = new SleepingQueens();
        Queen q = new Queen(10);

        Map<Position, Queen> queens = sq.getQueens();
        assertThrows(NoSuchElementException.class, () -> queens.keySet().iterator().next());
        assertEquals(0, queens.size());
    }

    @Test
    void getQueens() {
        SleepingQueens sq = new SleepingQueens();
        Queen q = new Queen(10);
        sq.addQueen(q);
        Map<Position, Queen> sqMap = sq.getQueens();

        Position position = sqMap.keySet().iterator().next();
        assertEquals(q, sqMap.get(position));
    }
}