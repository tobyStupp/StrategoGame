/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gui;

import Controller.GameController;
import Controller.StrategoController;
import Model.PieceType;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author toby
 */
public class ResultPanel extends JPanel {
    private ArrayList<ResultLabel>labels;
    
    public ResultPanel (){
        super();
        labels = new ArrayList<>();
        setLayout (new GridLayout(11,1));
        for (PieceType t : PieceType.values()){
            if (t!=PieceType.FLAG){
                ResultLabel label = new ResultLabel(Icons.getIcon(t.name()),t.getValue());
                add (label);
                labels.add(label);
                
                
            }
        }
    }
}
