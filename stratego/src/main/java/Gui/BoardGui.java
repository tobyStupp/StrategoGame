/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gui;

import Controller.GameController;
import Controller.InitController;
import Model.PieceType;
import java.awt.GridLayout;
import javax.swing.JPanel;

/**
 *
 * @author toby
 */
public class BoardGui extends JPanel{
    private Cell [][] boardG;
    private InitController controller;
    public BoardGui (InitController c){
        super ();
        setInitController(c);
        boardG = new Cell [10][10];
        setSize (650,650);
        setLayout(new GridLayout(10,10));
        for (int i = 0; i < 10; i++){
            for (int j = 0; j < 10; j++){
                if (!isSea(i,j)){
                boardG[i][j] = new Cell(i,j,c);
                add (boardG[i][j]);
                }
                else{
                    boardG[i][j] = new Cell(i,j);
                    add (boardG[i][j]);
                }
            }
            
                
        }
    }
    public boolean isSea (int row,int col){
        if (row==4 || row == 5){
            if (col == 2 || col == 3 || col ==6 || col==7) {
           
                return true;
            }
        
        }
        return false;
    }
    public void setInitController(InitController c){this.controller = c;}
    public void putPiece (PieceType t, int row, int col){
        (boardG[row][col]).putPiece(t,false);
    }
    public Cell getCell(int row, int col){return boardG[row][col];}
    public void startPlaying (GameController c){
         for (int i = 0; i < 10; i++){
            for (int j = 0; j < 10; j++){
                getCell(i,j).changeState(c);
            }
    }
    }
    
}
