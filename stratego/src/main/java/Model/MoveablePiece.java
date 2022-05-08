/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author toby
 */
public  class MoveablePiece extends Piece{
    
    public MoveablePiece(PieceType t, Player p) {
        super(t,p);
    }
    public void move (OccupiableSquare dest){
        OccupiableSquare sq = getPlace();
        sq.removePiece();
        dest.placePiece(this);
        
    }
    
}
