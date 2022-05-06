/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gui;

import Controller.InitController;
import Model.PieceType;
import java.awt.BorderLayout;
import java.util.Set;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author toby
 */
public class Frame extends JFrame {
    private BoardGui board;
    private ButtonPanel panel;
    
    public Frame (InitController c){
        super("GOOD LUCK");
        setSize (800,650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MessagePanel messagesL = new MessagePanel(c.getStrategoController());
        messagesL.setSize(this.getWidth(),50);
        getContentPane().add (messagesL, BorderLayout.SOUTH);
        c.addMessagePanel(messagesL);
             
        this.board = new BoardGui(c);
        c.addGuiBoard(board);
       
        getContentPane().add(board,BorderLayout.CENTER);
        panel = new ButtonPanel(c,this);
         c.addButtonPanel(panel);
        getContentPane().add (panel, BorderLayout.EAST);
        c.setUpBot();
        
        setVisible(true);
    }
    public void putPiece (PieceType type, int row, int col){
        board.putPiece(type, row, col);
    }
    public BoardGui getBoard(){return board;}
    public ButtonPanel getButtonPanel(){return panel;}
    
}
