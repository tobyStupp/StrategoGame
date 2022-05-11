/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author toby
 */
public enum PieceType {
    MARSHAL (10,"Marshal",1,true),
    GENERAL (9,"General",1,true),
    COLONEL (8, "Colonel",2,true),
    MAJOR (7,"Major",3,true),
    CAPTAIN (6, "Captain", 4,true),
    LIEUTENANT (5,"Lieutenant", 4,true),
    SERGEANT (4, "Sergeant", 5,true),
    MINERS (3, "Miner", 5,true),
    SCOUT (2, "Scout", 7,true),
    SPY (1, "Spy", 1,true),
    BOMB (20, "Bomb", 6,false),
    FLAG (1,"Flag", 1,false)
    ;
    private int val;
    private String name;
    private int count;
    private boolean moveable;
    PieceType (int val, String n, int c,boolean moveable){
        this.val = val;
        this.name = n;
        this.count = c;
        this.moveable =moveable;
    }
    public int getValue(){return this.val;}
    public String getName (){return this.name + ".png";}
    public int getCount(){return this.count;}
    public boolean isMoveable(){return this.moveable;}
    public int attack (PieceType pt){
        if (pt.val == val)
            return 0;
        if (val == 3 && pt.val ==20)
            return 1;
        if (val == 1 && pt.val==10)
            return 1;
        return val > pt.val ? 1 : -1;
    }
}
