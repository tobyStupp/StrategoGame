/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Gui.Cell;

/**
 *
 * @author toby
 */
public class OccupiableSquare extends Square {
    private Piece piece;
    private Cell cell;
    public OccupiableSquare (int row, int col){
        super (row, col);
    }
    public void setCell(Cell c){this.cell = c;}
    public boolean hasPiece(){return this.piece!=null;}
    public void placePiece (Piece p){
      
        this.piece = p;
        p.setPlace(this);
        this.cell.putPiece(piece.getPieceType(),p.isBot());
        
    }
    public Piece removePiece(){
       Piece p = this.piece;
       this.piece = null;
       p.remove();
       p.decreasePieces();
       cell.remove();

       return p;
    }
    public void movePiece(OccupiableSquare sq){
        Piece p = this.piece;
        this.piece = null;
        p.remove();
        cell.remove();
        sq.placePiece(p);
    }
    public Piece getPiece() {return piece;}
    public String toString(){
        if (hasPiece())
            return String.format("(%2d,%2d) %s", getRow(), getCol(), this.piece.getName());
        return super.toString() + " OCC";
    }
    public Player getPlayer(){return piece.getPlayer();}
    public void enbolden(){
        cell.bold();
    }
    public void unebolden(){
        cell.unbold();
    }
    
}
