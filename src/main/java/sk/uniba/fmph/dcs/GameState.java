package sk.uniba.fmph.dcs;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import main.java.sk.uniba.fmph.dcs.Queen;

public class GameState {
    public int numberOfPlayers;
    public int onTurn;
    public Set<SleepingQueenPosition> sleepingQueens;
    public Map<HandPosition, Optional.Card> cards;
    public Map<AwokenQueenPosition, Queen> awokenQueens;
    public List<Card> cardsDiscardedLastTurn;
}
