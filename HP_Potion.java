import java.util.*;
public class HP_Potion extends Item{ 
    public HP_Potion(){
        Item.name =  new String("HP Potion");
        Item.hp += 20;
        Item.exp = 0;
    }
    public void print(){
        System.out.println("Name : " + Item.name + " +HP = " + Item.hp);
    }
}