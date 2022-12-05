package sk.uniba.fmph.dcs;

public class AwokenQueenPosition {
    
    private int cardIdx;
    private int playerIdx;

    public AwokenQueenPosition(int cardIdx, int playerIdx){
        this.cardIdx = cardIdx;
        this.playerIdx = playerIdx;
    }
    
    public int getCardIndex(){
        return cardIdx;
    }

    public int getPlayerIndex(){
        return playerIdx;
    }
}
