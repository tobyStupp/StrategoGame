/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.OccupiableSquare;
import java.util.ArrayList;

/**
 *
 * @author toby
 */
public class GameMove {
    private OccupiableSquare attacker;
    private OccupiableSquare attacked;
    private ArrayList<OccupiableSquare> potentialMoves;
    public GameMove (OccupiableSquare a){
       
                 this.attacker = a;
                 
        
    }
    public void setPotentialMoves (ArrayList<OccupiableSquare> m){
        this.potentialMoves = m;
    }
    public OccupiableSquare getAttacker(){
        return attacker;
    }
    public boolean setAttacked (OccupiableSquare sq){
        if (this.potentialMoves.indexOf(sq)==-1){
            return false;
        }
        else{
            this.attacked = sq;
            return true;
        }
    }
    
}
