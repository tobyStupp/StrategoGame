/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.awt.Color;
import java.util.ArrayList;

/**
 *
 * @author toby
 */
public class Player {
    private Color color;
    private ArrayList<Piece> pieces=new ArrayList<Piece>();
    private int onBoard = 0;
    private int rowStart;
    
    public Player (Color col, int rowStart){
        this.color = col;
        this.rowStart=rowStart;
    }
    public void createPieces (){
        for (PieceType t : PieceType.values() ){
            for (int i = 0; i < t.getCount(); i++){
                if(t.isMoveable())
                 pieces.add (new MoveablePiece (t,this));
               else
                 pieces.add (new Piece (t, this)) ;
            }
        }    
    }
    public Piece findPiece (PieceType tp){
        for (Piece p : pieces){
            if (!p.onBoard()){
                if (p.getName().equals (tp.getName()))
                        return p;
            }
        }
        System.out.println("NO SUCH PIECE");
        return null;
    }
    public boolean inLimit (int row){
        return row>= rowStart && row < rowStart + 4;
    }
    public void putOnBoard (){onBoard++;}
    public void takeOff (){onBoard--;}
    public boolean allOnBoard(){return onBoard==40;}
}
