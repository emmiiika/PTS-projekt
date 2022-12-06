package sk.uniba.fmph.dcs;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class GameFinishedNoQueensLeft implements GameFinishedStrategy{

    private final Game game;
    public GameFinishedNoQueensLeft(Game game){
        this.game = game;
    }
    @Override
    public Optional<Integer> isFinished() {
        if(game.getSleepingQueens().getQueens().isEmpty()){
            List<Player> players = game.getPlayersList();

            int maxScorePlayerIdx = 0;
            int maxScore = 0;
            for(int i=0; i<players.size(); i++){
                Player player = players.get(i);
                Map<Position, Queen> awokenQueens = player.getAwokenQueens().getQueens();

                int sum = 0;
                for (Iterator<Position> it = awokenQueens.keySet().iterator(); it.hasNext(); ) {
                    Position position = it.next();
                    Queen queen = awokenQueens.get(position);
                    sum += queen.getPoints();
                }
                if(sum > maxScore){
                    maxScore = sum;
                    maxScorePlayerIdx = i;
                }
            }
            return Optional.of(maxScorePlayerIdx);
        }
        return Optional.empty() ;
    }
}
