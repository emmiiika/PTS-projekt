package sk.uniba.fmph.dcs;

import java.util.Optional;

public class GameFinished implements GameFinishedStrategy{

    public GameFinished(){}

    @Override
    public Optional<Integer> isFinished() {
        return Optional.empty();
    }
}
