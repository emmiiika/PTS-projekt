package sk.uniba.fmph.dcs;

import java.util.List;

public interface DrawingPileType {
    public List<Card> deal(DrawingAndTrashPile drawingAndTrashPile, List<Card> discard);
}
