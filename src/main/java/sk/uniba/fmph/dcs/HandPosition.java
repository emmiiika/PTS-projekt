package sk.uniba.fmph.dcs;

public class HandPosition {
    private int cardIndex;
    private int playerIdx;

    public HandPosition(int cardIndex, int playerIdx){
        this.cardIndex = cardIndex;
        this.playerIdx = playerIdx;
    }

    public int getCardIndex(){
        return cardIndex;
    }

    public int getPlayerIndex(){
        return playerIdx;
    }
}
