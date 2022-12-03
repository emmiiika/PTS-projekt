package sk.uniba.fmph.dcs;

public class AwokenQueenPosition {
    
    private int cardIndex;
    private int playerIndex;

    public AwokenQueenPosition(int playerIndex, int cardIndex){
        this.playerIndex = playerIndex;
        this.cardIndex = cardIndex;
    }
    
    public int getCardIndex(){
        return cardIndex;
    }

    public int getPlayerIndex(){
        return playerIndex;
    }
}
