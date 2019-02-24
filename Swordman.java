import java.util.*;
public class Swordman extends Novice{ 
    public Swordman(){
        Novice.job =  new String("Swordman");
        Novice.maxhp += 300;
        Novice.hp = Novice.maxhp;
        Novice.atk += 15;
    }
    
}