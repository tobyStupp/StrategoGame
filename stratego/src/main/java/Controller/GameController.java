/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Gui.BoardGui;
import Gui.Frame;
import Gui.MessagePanel;
import Gui.ResultPanel;
import Model.Board;
import Model.BotPlayer;
import Model.MoveablePiece;
import Model.OccupiableSquare;
import Model.Piece;
import Model.Player;
import Model.Square;
import java.awt.BorderLayout;
import java.awt.Container;
import java.util.ArrayList;

/**
 *
 * @author toby
 */
public class GameController {
    private Board board;
    private BoardGui boardG;
    private Player[] players;
    private ResultPanel panelR;
    private MessagePanel mp;
    private GameMove currentMove;
   
    public GameController (InitController c){
        this.board = c.getBoard();
        this.boardG = c.getBoardGui();
        this.players = c.getPlayers();
        this.mp = c.getMessagePanel();
        panelR = new ResultPanel();
        Frame cn = c.getButtonPanel().getParent();
      
        cn.getContentPane().remove(c.getButtonPanel());
     

        cn.getContentPane().add (panelR, BorderLayout.EAST);
        cn.revalidate();
        mp.changeMessage ("Playing: ");
        this.boardG.startPlaying(this);
    }
    public void press (int row, int col){
        OccupiableSquare sq = this.board.getSquare(row, col);
        //check if start of move
        if (currentMove == null){
            if (!sq.hasPiece()||(sq.getPlayer() instanceof BotPlayer || !(sq.getPiece() instanceof MoveablePiece) ))
                mp.changeMessage("Chose illegal Square");
            else{
                ArrayList<OccupiableSquare> potential =  getPotentialNeighbors(sq);
                if (potential.size()==0){
                    mp.changeMessage("No neighbors");
                }
                else{
                currentMove = new GameMove (sq);
                currentMove.setPotentialMoves(potential);
                mp.changeMessage("Started Move");
                sq.enbolden();
                }
            }
        }
        
            else{
            // check if this is undo
                 if (sq.getRow()==currentMove.getAttacker().getRow() && sq.getCol()==currentMove.getAttacker().getCol()){
                     currentMove.getAttacker().unebolden();
                     currentMove = null;   
                    }
                 // get attacker
                 else{
                     if (currentMove.setAttacked(sq)){
                         MoveablePiece p = (MoveablePiece)currentMove.getAttacker().getPiece();
                         Piece enemy = sq.getPiece();
                         currentMove.getAttacker().unebolden();
                         if (enemy!=null){
                             mp.changeMessage(String.format ("%s ==> %s", p.getName(),enemy.getName()));
                         }
                         else{
                             mp.changeMessage("Move Completed");
                             p.move(sq);
                             
                         
                         }
                         currentMove = null;
                     }
                     
                     
                 }
        
           }
               
        }
    //gets list of potential move
    public ArrayList<OccupiableSquare> getPotentialNeighbors(OccupiableSquare sq){
        Piece p = sq.getPiece();
        ArrayList<OccupiableSquare> neighbors = new ArrayList<OccupiableSquare>();
        //check under
        if (sq.getRow()< 9){
            Square sqN = board.getSquare(sq.getRow()+ 1, sq.getCol());
            if (sqN instanceof OccupiableSquare && (!((OccupiableSquare)sqN).hasPiece()||((OccupiableSquare)sqN).getPiece().differentPlayer(p)))
                neighbors.add ((OccupiableSquare)sqN);     
        }
         if (sq.getRow()> 0){
            Square sqN = board.getSquare(sq.getRow() - 1, sq.getCol());
            if (sqN instanceof OccupiableSquare && (!((OccupiableSquare)sqN).hasPiece()||((OccupiableSquare)sqN).getPiece().differentPlayer(p)))
                neighbors.add ((OccupiableSquare)sqN);   
        }
         if (sq.getCol()< 9){
            Square sqN = board.getSquare(sq.getRow(), sq.getCol()+1);
            if (sqN instanceof OccupiableSquare && (!((OccupiableSquare)sqN).hasPiece()||((OccupiableSquare)sqN).getPiece().differentPlayer(p)))
                neighbors.add ((OccupiableSquare)sqN);     
        }
         if (sq.getCol()> 0){
            Square sqN = board.getSquare(sq.getRow(), sq.getCol()-1);
            if (sqN instanceof OccupiableSquare && (!((OccupiableSquare)sqN).hasPiece()||((OccupiableSquare)sqN).getPiece().differentPlayer(p)) )
                neighbors.add ((OccupiableSquare)sqN);   
        }  
         return neighbors;
    }
        
    
    
    
}
