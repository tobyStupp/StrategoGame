/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Controller.InitController;
import java.awt.Color;

/**
 *
 * @author toby
 */
public class BotPlayer extends Player {
    public BotPlayer (){
        super (Color.RED, 6);
    }
    public void setUp (InitController controller){
        super.createPieces();
        int x = 0;
        for (PieceType t : PieceType.values()){
            int [][] places = BotSetUp.map1[x];
            for (int [] ar : places){
                controller.makeBotMove (t,ar[0],ar[1]);
            }
            x++;
        }
        
    }
}
