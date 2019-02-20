import java.util.*;
    
public class Main{
    static Scanner key = new Scanner(System.in);
    static Novice nov = new Novice();
    static private Bag bag = new Bag();

    public static void main(String[] args) {
        int num = 2;
        while(num > 1){
            nov.printStats();
            String act;
            System.out.println("Press 'a' to Acttack 'm' to move 'i' to Open inventery: ");
            act = key.next();
            nov.action(act);
           
        }
    }
}