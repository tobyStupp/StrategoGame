/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import javax.swing.ImageIcon;

/**
 *
 * @author toby
 */
public class Piece {
    private PieceType type;
    private OccupiableSquare currentPlace;
    private Player player;
    public Piece (PieceType p, Player play){
       this.type = p;
       this.player = play;
    }
    public String getName() {return type.getName();}
    public int getValue(){return type.getValue();}
    public boolean differentPlayer(Piece piece){
        return piece.player != player;
    }
    public void setPlace (OccupiableSquare sq){
   
        this.currentPlace = sq;
        
      
    }
    public void remove (){this.currentPlace = null;}
    public boolean onBoard (){return currentPlace!=null;}
    // returns <0 if param stronger
    // returns 0 if equal (both removed)
    // returns > 0 if stronger
    public  int attack (Piece p){
        switch (p.getValue()){
            case 3:
                if (p.getValue()==20)
                    return 1;
            case 1: 
                if (p.getValue()==10)
                    return 1;
            default:
        }
        if (getValue()==p.getValue())
            return 0;
        if (getValue() > p.getValue())
            return 1;
        return -1;
    }
    public PieceType getPieceType() {return this.type;}
    public boolean isBot(){return player instanceof BotPlayer;}
    
}
