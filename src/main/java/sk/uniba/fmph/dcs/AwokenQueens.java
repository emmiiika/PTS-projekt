package sk.uniba.fmph.dcs;


import java.util.*;

public class AwokenQueens implements QueenCollection{
    private int playerIdx;
    private List<Queen> awokenQueens;

    public AwokenQueens(int playerIdx){
        this.playerIdx = playerIdx;
        this.awokenQueens = new ArrayList<>();
    }

    @Override
    public void addQueen(Queen queen) {
        awokenQueens.add(queen);
    }

    @Override
    public Optional<Queen> removeQueen(SleepingQueenPosition position) {
        return Optional.empty();
    }

    @Override
    public Optional<Queen> removeQueen(AwokenQueenPosition position) {
        int index = position.getCardIndex();
        Optional<Queen> optional;

        if(index < awokenQueens.size()){
            Queen queen = awokenQueens.remove(index);
            optional = Optional.of(queen);
        }
        else{
            optional = Optional.empty();
        }

        return optional;
    }

    @Override
    public Map<Position, Queen> getQueens() {
        Map<Position, Queen> queensPositions = new HashMap<>();

        for(int i=0; i<awokenQueens.size(); i++){
            Position position = new Position(new AwokenQueenPosition(i, playerIdx));
            queensPositions.put(position, awokenQueens.get(i));
        }

        return queensPositions;
    }
}
