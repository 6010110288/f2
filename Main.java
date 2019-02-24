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
            action(act.charAt(0));
            if(nov.level() >= 5 && nov.job.equals("Novice")){
                while(num > 1){
                    System.out.println("Select your new job \n Swordman(s) or Archer(a)");
                    act = key.next();
                    if(act.charAt(0) == 's'){nov = new Swordman();break;}
                    else if(act.charAt(0) == 'h'){nov = new Archer();break;}
                    else{break;}
                }
            }
        }
    }
    public static void action(char act){
        switch(act){
            case 'a':{nov.attack();break;}
            case 'm':{nov.move();break;}
            case 'i':{nov.inventery();break;}
        }
    }
}