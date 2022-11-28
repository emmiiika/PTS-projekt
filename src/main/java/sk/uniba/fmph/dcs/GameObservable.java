package sk.uniba.fmph.dcs;

public class GameObservable {

    public GameObservable(){}
    
    public void add(GameObserver observer){}

    public void addPlayer(int playerIdx, GameObserver observer){}

    public void remove(GameObserver observer){}

    public void notifyAll(GameState message){}
}
