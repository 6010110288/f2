import java.util.*;
public class Rand{
    public int rand_drop(){
        Random rand = new Random();
        int n = rand.nextInt(4);
        return n;
    }
    public int rand_item(){
        Random rand = new Random();
        int n = rand.nextInt(3);
        while(n == 0){
            n = rand.nextInt(3);
        }
        return n;
    }
}