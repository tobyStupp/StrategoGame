/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gui;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author toby
 */
public class ResultLabel extends JLabel {
    private ImageIcon icon;
    private int value;
    private int redCount;
    private int blueCount;
    public ResultLabel (ImageIcon icon, int value){
        this.icon = icon;
        setIcon(icon);
        setText(getMessage());             
        this.value = value;
    }
    public String getMessage (){
        return String.format ("%4d RED, %4d BLUE", redCount, blueCount);
    }
    public void increaseRed(){
        this.redCount++;
        setText(getMessage());
    }
    public void increaseBlue(){
        this.blueCount++;
        setText(getMessage());
    }
    public int getValue(){return this.value;}
    
}
