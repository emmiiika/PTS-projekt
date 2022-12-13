package sk.uniba.fmph.dcs;

public class SleepingQueenPosition implements Position {
    private final int cardIndex;

    public SleepingQueenPosition(int cardIndex) {
        this.cardIndex = cardIndex;
    }

    @Override
    public int getCardIndex() {
        return cardIndex;
    }

    @Override
    public int getPlayerIndex() {
        return -1;
    }
}
