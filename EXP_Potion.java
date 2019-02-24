import java.util.*;
public class EXP_Potion extends Item{ 
    public EXP_Potion(){
        Item.name =  new String("EXP Potion");
        Item.hp += 0;
        Item.exp = 20;
    }
    public void print(){
        System.out.println("Name : " + Item.name + " +EXP = " + Item.exp);
    }
}