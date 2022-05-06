/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gui;

import Controller.GameController;
import Controller.InitController;
import Model.PieceType;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author toby
 */
public class Cell extends JLabel{
    private ImageIcon icon;
    private boolean blank ;
    private int row;
    private int col;
    
    class PlayGameClick implements MouseListener{
        private GameController controller;
        public PlayGameClick (GameController c){
            this.controller = c; 
        }
        @Override
        public void mouseClicked(MouseEvent e) {
            JOptionPane.showMessageDialog(null, "It works");
        }

        @Override
        public void mousePressed(MouseEvent e) {
            
        }

        @Override
        public void mouseReleased(MouseEvent e) {
          
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            
        }

        @Override
        public void mouseExited(MouseEvent e) {
            
        }
        
    }
    class InitMouseClick implements MouseListener{
        InitController controller ;
        public InitMouseClick(InitController c){
            this.controller = c;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
           Cell cell = (Cell)e.getSource();
           controller.completeMove(cell.row, cell.col);
          
           
        }

        @Override
        public void mousePressed(MouseEvent e) {
            
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            
        }

        @Override
        public void mouseExited(MouseEvent e) {
            
        }
    }
    public Cell (int row, int col, InitController c){
        super ();
         setBorder(BorderFactory.createLineBorder (Color.BLACK,2));
        icon = Icons.getIcon("BLANK");
        setIcon(icon);
        this.row = row;
        this.col = col;
        addMouseListener (new InitMouseClick(c));
    }
    public Cell (int row, int col){
        icon = Icons.getIcon("SEA");
        setIcon (icon);
    }
    public int getRow(){return row;}
    public int getCol(){return col;}
    public void putPiece (PieceType p, boolean isBot){
        if (!isBot)
            this.icon = Icons.getIcon(p.name());
        else
            this.icon = Icons.getBotPict();
        setIcon (icon);
    }
    public void remove (){
        this.icon = Icons.getIcon ("BLANK");
        setIcon(icon);
    }
    public void changeState (GameController gc){
        this.removeMouseListener(getMouseListeners()[0]);
        this.addMouseListener(new PlayGameClick(gc));
    }
    
    
    
}
