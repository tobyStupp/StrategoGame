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
import javax.swing.border.BevelBorder;

/**
 *
 * @author toby
 */
public class Cell extends JLabel{
    private ImageIcon icon;
    private boolean blank ;
    private int row;
    private int col;
    private MouseListener listener;
    
    class PlayGameClick implements MouseListener{
        private GameController controller;
        public PlayGameClick (GameController c){
            this.controller = c; 
        }
        @Override
        public void mouseClicked(MouseEvent e) {
          if (listener==this){
            Cell c = (Cell)e.getSource();
            controller.press(c.row, c.col);
          }
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
        listener = new InitMouseClick(c);
        addMouseListener (listener);
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
      
        this.removeMouseListener(listener);
        listener = new PlayGameClick(gc);
        this.addMouseListener(listener);
    }
    public void bold(){
        setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
    }
    public void unbold(){
        setBorder(BorderFactory.createLineBorder (Color.BLACK,2));
    }
    
    
    
}
