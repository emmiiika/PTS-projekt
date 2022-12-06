package sk.uniba.fmph.dcs;

import java.util.*;

public class SleepingQueens implements QueenCollection{

    private List<Queen> sleepingQueens;

    public SleepingQueens(){
        this.sleepingQueens = new ArrayList<>();
        for(int i=0; i<4; i++){
            Queen queen = new Queen(5);
            this.sleepingQueens.add(queen);
            queen = new Queen(10);
            this.sleepingQueens.add(queen);

            if(i == 0){
                queen = new Queen(20);
                this.sleepingQueens.add(queen);
            }
            else{
                queen = new Queen(15);
                this.sleepingQueens.add(queen);
            }
        }

        Collections.shuffle(sleepingQueens);
    }

    @Override
    public void addQueen(Queen queen) {
        sleepingQueens.add(queen);
    }

    @Override
    public Optional<Queen> removeQueen(SleepingQueenPosition position) {
        int index = position.getCardIndex();
        Optional<Queen> optional;

        if(index < sleepingQueens.size()){
            Queen queen = sleepingQueens.remove(index);
            optional = Optional.of(queen);
        }
        else{
            optional = Optional.empty();
        }

        return optional;
    }

    @Override
    public Optional<Queen> removeQueen(AwokenQueenPosition position) {
        return Optional.empty();
    }

    @Override
    public Map<Position, Queen> getQueens() {
        Map<Position, Queen> queensPositions = new HashMap<>();

        for(int i=0; i<sleepingQueens.size(); i++){
            Position position = new Position(new SleepingQueenPosition(i));
            queensPositions.put(position, sleepingQueens.get(i));
        }

        return queensPositions;
    }
}
