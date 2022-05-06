/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Gui.BoardGui;
import Gui.Frame;
import Gui.ResultPanel;
import Model.Board;
import Model.Player;
import java.awt.BorderLayout;
import java.awt.Container;

/**
 *
 * @author toby
 */
public class GameController {
    private Board board;
    private BoardGui boardG;
    private Player[] players;
    private ResultPanel panelR;
    public GameController (InitController c){
        this.board = c.getBoard();
        this.boardG = c.getBoardGui();
        this.players = c.getPlayers();
        panelR = new ResultPanel();
        Frame cn = c.getButtonPanel().getParent();
      
        cn.getContentPane().remove(c.getButtonPanel());
     

        cn.getContentPane().add (panelR, BorderLayout.EAST);
        cn.revalidate();
        this.boardG.startPlaying(this);
    }
    
    
}
