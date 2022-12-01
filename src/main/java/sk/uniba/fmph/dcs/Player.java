package sk.uniba.fmph.dcs;

import java.util.List;

public class Player {

    private Hand playersHand;
    private AwokenQueens awokenQueens;
    private Game game;

    public Player(){
        playersHand = new Hand();
    }

    public void play(List<Position> cards){}
    
    public PlayerState getPlayerState(){
        return null;
    }

    public List<Card> getPlayersCards(){
        return playersHand.getCards();
    }

    public AwokenQueens getPlayersAwokenQueens(){
        return awokenQueens;
    }
}