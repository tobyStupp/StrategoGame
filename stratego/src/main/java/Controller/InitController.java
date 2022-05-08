/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Gui.BoardGui;
import Gui.ButtonPanel;
import Gui.ChoiceButtons;
import Gui.MessagePanel;
import Model.Board;
import Model.BotPlayer;
import Model.OccupiableSquare;
import Model.Piece;
import Model.PieceType;
import Model.Player;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author toby
 */
public class InitController {
    private Player [] players;
    private int currentPlayer;
    private Board board;
    private BoardGui boardG;
    private ButtonPanel panel;
    private MessagePanel messageP;
    private ArrayList<Move> moves;
    private Move currentMove;
    private StrategoController mainControl;
    private boolean finished;
    public InitController (Board b){
        this.board =b;
        
        Player p = new Player (Color.blue,0);
        p.createPieces();
        players= new Player[]{p, new BotPlayer()};
       
        
        
    }
    public void setStrategoController(StrategoController c){
        this.mainControl = c;
    }
    public void setUpBot(){
         ((BotPlayer)players[1]).setUp(this);
         System.out.println(board);
    }
    public void addGuiBoard (BoardGui bg){
        this.boardG = bg;
        board.addObserver(bg);
    }
    public void addButtonPanel(ButtonPanel p){
        this.panel = p;
    }
    public void addMessagePanel(MessagePanel mp){
        this.messageP = mp;
    }
    public void startMove (ChoiceButtons b){
        currentMove = new Move(b, players[currentPlayer]);
    }
    public void completeMove(int row, int col){
       OccupiableSquare s = board.getSquare(row, col);
       //check to see if empty therefore removing
       if (s==null){
           JOptionPane.showMessageDialog(null, "Illegal Move");
           return;
       }
       if (s.hasPiece()){
           Piece t = s.removePiece();
           ChoiceButtons b = panel.find(t.getPieceType());
           if (b!=null){
               b.increase();
               b.setEnabled(true);
               if (finished){
                   finished = false;
                   messageP.reset();
               }
               
           }
           
        
       }
       else{
       currentMove.addSquare(s);
       
       if (!currentMove.executed())
           JOptionPane.showMessageDialog (null,"Illegal move");
       else
       {
            System.out.println(board);
            currentMove.releaseCell();
            if (players[0].allOnBoard()){
                messageP.start();
                finished = true;
            }
          
                    
               
       }
       }
    }
    public MessagePanel getMessagePanel(){return this.messageP;}
   
    public void makeBotMove(PieceType t, int x, int y){
       OccupiableSquare s = board.getSquare(x, y); 
       Move m = new Move(null,players[1] );
       m.addSquare(s,t);
    }
    public Board getBoard(){return this.board;}
    public BoardGui getBoardGui(){return this.boardG;}
    public Player[] getPlayers (){return this.players;}
    public ButtonPanel getButtonPanel(){return this.panel;}
    public StrategoController getStrategoController () {return this.mainControl;}
    
}
