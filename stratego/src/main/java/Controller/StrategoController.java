/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Board;
import java.util.HashSet;

/**
 *
 * @author toby
 */
public class StrategoController {
    private InitController init;
    private GameController game;
    public StrategoController (Board b){
        this.init = new InitController(b);
        init.setStrategoController(this);
        
    }
    public InitController getInitController(){return this.init;}
    public void tranisiton(){
        game = new GameController (init);
        
    }
    
}
