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
        Game game = new Game(drawingAndTrashPile, sleepingQueens);
        EvaluateAttack evaluateAttack = new EvaluateAttack(game);

        List<Player> players = new ArrayList<>();
        players.add(new Player(0, game));
        players.add(new Player(1, game));

        game.setPlayerList(players);

        AwokenQueenPosition awokenQueenPosition = new AwokenQueenPosition(0,0);
        SleepingQueenPosition sleepingQueenPosition = new SleepingQueenPosition(0);

        Position awokenPosition = new Position(awokenQueenPosition);
        Position sleepingPosition = new Position(sleepingQueenPosition);





    }
}