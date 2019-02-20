import java.util.*;

public class Item{
    public String name;
    public int exp;
    public int hp;
    public void itemlist(int itemNO){
        switch(itemNO){
            case 1: name = new String("HP Potion"); hp = 10; exp = 0;break;
            case 2: name = new String("EXP Potion"); hp = 0; exp = 10;break;  
        }
    }

}