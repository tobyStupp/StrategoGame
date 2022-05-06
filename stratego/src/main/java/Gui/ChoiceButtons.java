/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gui;

import Controller.InitController;
import Model.PieceType;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

/**
 *
 * @author toby
 */
public class ChoiceButtons extends JButton implements MouseListener{
    private PieceType type;
    private int left;
    private ImageIcon  icon;
    private InitController controller;
    public String getMessage (){
        return String.format ("name: %s not placed: %d", type.name(), left);
    }
    public ChoiceButtons (PieceType t, InitController c){
        super();
        this.controller =c;
        this.type = t;
        icon = Icons.getIcon(type.name());
        this.left = t.getCount();
        setIcon (icon);
        setText (getMessage());
        setHorizontalAlignment(SwingConstants.LEFT);
        addMouseListener (this);
    }
    public PieceType getPieceType(){return type;}
    public void decrease (){
        this.left--;
        setText (getMessage());
         if (left==0)
            setEnabled(false);
    }
    public void increase (){
        this.left++;
        setText(getMessage());
       
    }

    @Override
    public void mouseClicked(MouseEvent e) {
       //JOptionPane.showMessageDialog(this,type.name());
       controller.startMove (this);
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
