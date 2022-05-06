
import Controller.InitController;
import Controller.StrategoController;
import Gui.BoardGui;
import Gui.Frame;
import Gui.Icons;
import Model.Board;
import Model.PieceType;
import Model.Player;
import java.awt.Color;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author toby
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Board b = new Board();
        System.out.println(b);
       
     
        Icons.initialize();
       
        StrategoController controller = new StrategoController (b);
        Frame f = new Frame (controller.getInitController());
        
       
        
               
        
    }
    
}
