package sk.uniba.fmph.dcs;

import java.util.Optional;

public class Position {

    private Optional<HandPosition> handPosition = Optional.empty();
    private Optional<SleepingQueenPosition> sleepingQueenPosition = Optional.empty();
    private Optional<AwokenQueenPosition> awokenQueenPosition = Optional.empty();

    public Position(HandPosition handPosition){
        this.handPosition = Optional.of(handPosition);
    }
    public Position(SleepingQueenPosition sleepingQueenPosition){
        this.sleepingQueenPosition = Optional.of(sleepingQueenPosition);
    }
    public Position(AwokenQueenPosition awokenQueenPosition){
        this.awokenQueenPosition = Optional.of(awokenQueenPosition);
    }

    public Optional<HandPosition> getHandPosition(){
        return handPosition;
    }
    public Optional<SleepingQueenPosition> getSleepingQueenPosition(){
        return sleepingQueenPosition;
    }
    public Optional<AwokenQueenPosition> getAwokenQueenPosition(){
        return awokenQueenPosition;
    }
}
