/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author toby
 */
public class Square {
    private int row;
    private int col;
    public Square (int row, int col){
        this.row = row;
        this.col = col;
    }
    public int getRow(){return row;}
    public int getCol () {return col;}
    public String toString (){
       return String.format ("(%d,%d)SQUARE", row, col);
    }
    
}
