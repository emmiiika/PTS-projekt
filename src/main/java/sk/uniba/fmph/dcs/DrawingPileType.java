package sk.uniba.fmph.dcs;

import java.util.List;
import java.util.Random;

interface DrawingPileType {
    public List<Card> deal(DrawingAndTrashPile drawingAndTrashPile, Random random, List<Card> discard);
}
