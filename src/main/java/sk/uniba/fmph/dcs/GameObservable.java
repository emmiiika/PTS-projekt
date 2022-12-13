package sk.uniba.fmph.dcs;

import java.util.ArrayList;
import java.util.List;

public class GameObservable {

    private List<GameObserver> observers;
    private List<Integer> players;


    public GameObservable() {
        this.players = new ArrayList<>();
        this.observers = new ArrayList<>();
    }


    public void add(GameObserver observer) {
        observers.add(observer);
    }

    public void addPlayer(int playerIdx, GameObserver observer) {
        players.add(playerIdx);
        observers.add(observer);

    }

    public void remove(GameObserver observer) {
        observers.remove(observer);
    }

    public void notifyAll(GameState message) {
        for (GameObserver observer : observers) {
            observer.notify(message); // REVIEW: the message sent to different players observing the game is the same, but it should be different
        }
    }
}
