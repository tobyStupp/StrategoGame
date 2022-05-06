/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gui;

import Controller.InitController;
import Model.PieceType;
import java.awt.Container;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author toby
 */
public class ButtonPanel extends JPanel {
    private Frame parent;
    private ArrayList<ChoiceButtons> buttons;
    public ButtonPanel (InitController c, Frame parent){
        super();
        setLayout (new GridLayout(12,1));
        this.parent = parent;
        buttons = new ArrayList<ChoiceButtons>();
        for (PieceType t : PieceType.values()){
            ChoiceButtons b = new ChoiceButtons(t,c);
            add (b);
            buttons.add(b);
            
        }
    }
    public ChoiceButtons find (PieceType t){
        for (ChoiceButtons b : buttons){
            if (b.getPieceType()==t)
                return b;
        }
        return null;
    }
    public Frame getParent(){return this.parent;}
}
