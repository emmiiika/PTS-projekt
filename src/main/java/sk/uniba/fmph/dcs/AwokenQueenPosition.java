package sk.uniba.fmph.dcs;

public class AwokenQueenPosition implements Position {

    private final int cardIdx;
    private final int playerIdx;

    public AwokenQueenPosition(int cardIdx, int playerIdx) {
        this.cardIdx = cardIdx;
        this.playerIdx = playerIdx;
    }

    @Override
    public int getCardIndex() {
        return cardIdx;
    }

    @Override
    public int getPlayerIndex() {
        return playerIdx;
    }
}
