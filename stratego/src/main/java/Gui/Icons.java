/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gui;

import Model.PieceType;
import java.util.HashMap;
import javax.swing.ImageIcon;

/**
 *
 * @author toby
 */
public class Icons {
    private static HashMap <String, ImageIcon> map=new HashMap<>();
    private static String dir = "D:\\JavaPrograms\\stratego\\src\\main\\java\\Gui\\Picts\\";
    public static void initialize (){
        for (PieceType t : PieceType.values()){
            ImageIcon icon = new ImageIcon(Icons.dir + t.getName());
            map.put(t.name(), icon);
        }
        ImageIcon i =new ImageIcon(dir+"Blank.png");
        map.put ("BLANK",i);
        i =new ImageIcon(dir+"botPiece.png");
        map.put ("OPPONENT", i);
        i = new ImageIcon (dir + "sea.png");
        map.put ("SEA", i);
    }
    public static ImageIcon getIcon (String pName){return map.get(pName);}
    public static ImageIcon getBotPict() {return map.get ("OPPONENT");}
}
