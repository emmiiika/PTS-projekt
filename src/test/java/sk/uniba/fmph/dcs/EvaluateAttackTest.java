package sk.uniba.fmph.dcs;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EvaluateAttackTest {

    @Test
    void play() {
        DrawingAndTrashPile drawingAndTrashPile = new DrawingAndTrashPile();

        SleepingQueens sleepingQueens = new SleepingQueens();
        Queen queen = new Queen(15);
        sleepingQueens.addQueen(queen);
        queen = new Queen(10);
        sleepingQueens.addQueen(queen);
        queen = new Queen(5);
        sleepingQueens.addQueen(queen);

        Game game = new Game(drawingAndTrashPile, sleepingQueens);
        EvaluateAttack evaluateAttack = new EvaluateAttack(game);

        List<Player> players = new ArrayList<>();
        players.add(new Player(0, game));
        players.add(new Player(1, game));

        AwokenQueens awokenQueens1 = new AwokenQueens(1);
        queen = new Queen(10);
        awokenQueens1.addQueen(queen);
        AwokenQueens awokenQueens2 = new AwokenQueens(1);

        players.get(0).setAwokenQueens(awokenQueens1);
        players.get(1).setAwokenQueens(awokenQueens2);

        game.setPlayerList(players);

        AwokenQueenPosition awokenQueenPosition = new AwokenQueenPosition(0,0);
        SleepingQueenPosition sleepingQueenPosition = new SleepingQueenPosition(0);

        Position awokenPosition = new Position(awokenQueenPosition);
        Position sleepingPosition = new Position(sleepingQueenPosition);

        assertTrue(evaluateAttack.play(awokenPosition, 1));







    }
}