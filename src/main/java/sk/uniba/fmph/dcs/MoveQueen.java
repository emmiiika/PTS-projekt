package sk.uniba.fmph.dcs;

public class MoveQueen{

    private int attacker;
    private int defender;
    private CardType actionBasedOf;

    public MoveQueen(CardType defenseCardType, int attacker, int defender){
        this.attacker = attacker;
        this.defender = defender;
        this.actionBasedOf = defenseCardType;
    }
    
    public boolean play(Position targetQueen){
        switch(actionBasedOf){
            case KNIGHT:
                
        }
        return false;
    }
}