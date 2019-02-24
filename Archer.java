import java.util.*;
public class Archer extends Novice{ 
    public Archer(){
        Novice.job =  new String("Archer");
        Novice.maxhp += 50;
        Novice.hp = Novice.maxhp;
        Novice.atk += 60;
    }
    
}