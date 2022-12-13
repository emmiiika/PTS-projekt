package sk.uniba.fmph.dcs;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class GameFinishedPlayers implements GameFinishedStrategy {

    private final Game game;

    public GameFinishedPlayers(Game game) {
        this.game = game;
    }

    @Override
    public Optional<Integer> isFinished() {

        List<Player> players = game.getPlayersList();
        int playerOnTurn = game.playerOnTurn();
        Player player = players.get(playerOnTurn);

        if (players.size() == 2 || players.size() == 3) {
            AwokenQueens awokenQueens = player.getAwokenQueens();

            if (awokenQueens.getQueens().size() == 5) {
                return Optional.of(playerOnTurn);
            } else {
                int sum = 0;

                Map<Position, Queen> awokenQueensMap = player.getAwokenQueens().getQueens();
                for (Position position : awokenQueensMap.keySet()) {
                    Queen queen = awokenQueensMap.get(position);
                    sum += queen.getPoints();
                }

                if (sum >= 50) {
                    return Optional.of(playerOnTurn);
                } else {
                    return Optional.empty();
                }
            }
        } else {
            AwokenQueens awokenQueens = player.getAwokenQueens();

            if (awokenQueens.getQueens().size() == 4) {
                return Optional.of(playerOnTurn);
            } else {
                int sum = 0;

                Map<Position, Queen> awokenQueensMap = player.getAwokenQueens().getQueens();
                for (Position position : awokenQueensMap.keySet()) {
                    Queen queen = awokenQueensMap.get(position);
                    sum += queen.getPoints();
                }

                if (sum >= 40) {
                    return Optional.of(playerOnTurn);
                } else {
                    return Optional.empty();
                }
            }
        }
    }
}
