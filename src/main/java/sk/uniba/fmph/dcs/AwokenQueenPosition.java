package sk.uniba.fmph.dcs;

public class AwokenQueenPosition {
    
    private int cardIdx; // REVIEW: this can be final, the same as most of the other variables in the other classes
    private int playerIdx;

    public AwokenQueenPosition(int cardIdx, int playerIdx){ // REVIEW: please use formatting in your IDE, it will make the code more readable
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
