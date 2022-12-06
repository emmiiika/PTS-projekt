package sk.uniba.fmph.dcs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class AwokenQueensTest {

    @Test
    void addQueen() {
        AwokenQueens aq = new AwokenQueens(0);
        Queen q = new Queen(10);
        aq.addQueen(q);
        Map<Position, Queen> queens = aq.getQueens();
        Queen queen = queens.get(queens.keySet().iterator().next());

        assertEquals(1, queens.size());
        assertEquals(q, queen);

    }

    @Test
    void removeQueen() {
        AwokenQueens aq = new AwokenQueens(0);
        Queen q = new Queen(10);
        aq.addQueen(q);
        Map<Position, Queen> queens = aq.getQueens();
        Position position = queens.keySet().iterator().next();

        assertTrue(position.getSleepingQueenPosition().isEmpty());
        assertTrue(position.getAwokenQueenPosition().isPresent());

        AwokenQueenPosition awokenQueenPosition = position.getAwokenQueenPosition().get();
        Optional<Queen> queen = aq.removeQueen(awokenQueenPosition);
        assertTrue(queen.isPresent());
        assertEquals(q, queen.get());
    }

    @Test
    void removeQueenNotInAQ() {
        AwokenQueens aq = new AwokenQueens(0);
        Queen q = new Queen(10);

        Map<Position, Queen> queens = aq.getQueens();
        assertThrows(NoSuchElementException.class, () -> queens.keySet().iterator().next());
        assertEquals(0, queens.size());
    }

    @Test
    void getQueens() {
        AwokenQueens aq = new AwokenQueens(0);
        Queen q = new Queen(10);
        aq.addQueen(q);
        Map<Position, Queen> aqMap = aq.getQueens();

        Position position = aqMap.keySet().iterator().next();
        assertEquals(q, aqMap.get(position));
    }
}