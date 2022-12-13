package sk.uniba.fmph.dcs;

import java.util.Map;
import java.util.Optional;

public class PlayerState {

    public Map<Integer, Optional<Card>> cards;
    public Map<Integer, Queen> awokenQueens;

    public PlayerState(Map<Integer, Optional<Card>> cards, Map<Integer, Queen> awokenQueens) {
        this.cards = cards;
        this.awokenQueens = awokenQueens;
    }


}
