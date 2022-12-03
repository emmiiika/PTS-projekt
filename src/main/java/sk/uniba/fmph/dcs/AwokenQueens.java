package sk.uniba.fmph.dcs;

import java.util.ArrayList;
import java.util.List;

public class AwokenQueens extends QueenCollection{
    
    private List<Queen> awokenQueens;

    public AwokenQueens(){
        awokenQueens = new ArrayList<>();
    }

    public int getCount(){
        return awokenQueens.size();
    }
}
