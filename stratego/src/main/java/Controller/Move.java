/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Gui.ChoiceButtons;
import Model.OccupiableSquare;
import Model.Piece;
import Model.PieceType;
import Model.Player;

/**
 *
 * @author toby
 */
public class Move {
    private ChoiceButtons button;
    private OccupiableSquare square;
    private Player p;
    private boolean executed;
    public Move (ChoiceButtons b, Player p){
        this.button= b;
        this.p = p;
    }
    public void addSquare (OccupiableSquare sq){
        if (sq==null) return;
        if (!p.inLimit(sq.getRow())) return;
        if (!executed){
            this.square = sq;
            Piece pc= p.findPiece(button.getPieceType());
            if (pc == null) return;
            sq.placePiece(pc);
            p.putOnBoard();
            button.decrease();
            this.executed = true;
        }
        
    }
    public void addSquare (OccupiableSquare sq,PieceType type){
        if (sq==null) return;
        if (!executed){
            this.square = sq;
            Piece pc= p.findPiece(type);
            if (pc == null) return;
            sq.placePiece(pc);
            p.putOnBoard();
          
       
            this.executed = true;
        }
        
    }
    public boolean executed() {return executed;}
    public void releaseCell(){
        this.square = null;
        executed=false;
    }
   
    
}
