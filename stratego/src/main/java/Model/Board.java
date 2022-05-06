/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Gui.BoardGui;

/**
 *
 * @author toby
 */
public class Board {
    private Square[][] board;
    public Board(){
        board = new Square [10][10];
        for (int i = 0; i < 4; i++){
            for (int j=0; j< 10; j++){
                board[i][j] = new OccupiableSquare(i, j);
                board [i+6][j] = new OccupiableSquare(i,j);
            }
        }
        for (int i = 4; i < 6;i++)
          for (int k = 0; k < 5; k++)
            for (int j = 0; j < 2; j++){
                if (k%2==0)
                    board [i][k*2 +j] = new OccupiableSquare(i,k*2+j);
                else
                    board [i][k*2 + j] = new Square (i, k*2+j);
                }
                
            
    }
    public String toString(){
        String s ="";
        for (int i = 0; i < 10; i++){
            for (int j = 0; j < 9; j++)
                s+= board[i][j].toString() + ", ";
            s+= board[i][9] + "\n";
        }
        return s;
    }
    public boolean placePiece (Player p, PieceType t, int row, int col){
        Piece f= p.findPiece(t);
        if (f==null) return false;
        if (!p.inLimit(row))
            return false;
       OccupiableSquare place = (OccupiableSquare) board[row][col];
       if (place.hasPiece()){
           System.out.println("PIECE ALREADY THERE");
           return false;
       }
       p.putOnBoard();
       place.placePiece(f);
       return true;
    }
    public void addObserver (BoardGui g){
        for (int i = 0; i < 10; i++){
            for (int j = 0; j < 10; j++){
                if (board[i][j] instanceof OccupiableSquare)
                   ( (OccupiableSquare)board[i][j]).setCell (g.getCell(i, j));
            }
        }
        
    }
    public OccupiableSquare getSquare (int row , int col){
        Square s = board[row][col];
        if (s instanceof OccupiableSquare)
            return (OccupiableSquare) s;
        return null;
    }
    
    
}
