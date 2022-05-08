/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gui;

import Controller.StrategoController;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author toby
 */
public class MessagePanel extends JPanel implements ActionListener {
    private JButton cont;
    private JLabel messageLabel;
    private StrategoController control;
    public MessagePanel(StrategoController control){
        super();
        this.control = control;
        Font font = new Font("Comic sans", Font.BOLD,14);
        cont = new JButton ("Start Game");
        cont.setFont(font);
        cont.setEnabled(false);
        cont.addActionListener(this);
        add(cont);
        messageLabel=new JLabel("SETTING UP GAME");
        messageLabel.setAlignmentX(CENTER_ALIGNMENT);
        add (messageLabel);
    }
    public void changeMessage(String message){
        this.messageLabel.setText(message);
    }
    public void start (){cont.setEnabled(true);}
    public void reset (){cont.setEnabled(false);}

    @Override
    public void actionPerformed(ActionEvent e) {
        remove(cont);
        this.revalidate();
        control.tranisiton ();        
    }
}
