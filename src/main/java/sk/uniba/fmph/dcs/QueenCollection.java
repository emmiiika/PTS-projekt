package sk.uniba.fmph.dcs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class QueenCollection {

    private List<Queen> queens;
    
    public QueenCollection(){
        this.queens = new ArrayList<>(12);
    }

    public void addQueen(Queen queen){
        queens.add(queen);
    }

    public Optional<Queen> removeQueen(SleepingQueenPosition position){
        int index = position.getCardIndex();
        Optional<Queen> optional;
        if(index < queens.size()){
            Queen queen = queens.remove(index);
            optional = Optional.of(queen);
        }
        else{
            optional = Optional.empty();
        }

        return optional;
    }


    // tu nie je nejak doriesene to, ze chcem pozicie vsetkych kralovien,
    // nie len spiacich

    public Map<Position, Queen> getQueens(){
        Map<Position, Queen> queensPositions = new HashMap<>();

        for(int i=0; i<queens.size(); i++){
            Position position = new Position(new SleepingQueenPosition(i));
            queensPositions.put(position, queens.get(i));
        }

        return queensPositions;
    }
}
