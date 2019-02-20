import java.util.*;
public class Novice{    
    Scanner scan = new Scanner(System.in);
    Rand rand = new Rand();
    private  int maxhp = 10;
    private  int hp = 10;
    private  int exp = 0;
    private  int level = 1;
    private Bag bag = new Bag();
    private Item item = new Item();
    
        public  void printStats(){
            System.out.println("CLASS: Novice HP: " + hp + " LEVEL: " + level + " EXP: " + exp + "\n");
        }
        public  void action(String act) {
            if(act.charAt(0) == 'a'){
                exp = exp +( 100/level );
                System.out.println("Yor earn :" + exp + "exp!!\n");
            }
            if(act.charAt(0) == 'm'){
                if(hp > (3 + level / 2)){
                    hp = hp - (3 + (level/2));
                    if(rand.rand_drop() == 3){
                        bag.find_item(rand.rand_item());
                    }
                    System.out.println("You lost " + (3 + (level/2)) + "HP \n");
                }
                else{
                    System.out.println("You are Died!!");
                    gameOver();
                }
            }
            if(act.charAt(0) == 'i'){
                bag.info();
                use_item();
                
            }
            
            levelUp();
            return;

        }
        private void use_item(){
            System.out.println("Select item No.(1/2) to use or Exit (other key)");
            Scanner scan = new Scanner(System.in);
            String act = scan.next();
            if(act.charAt(0) == '1' || act.charAt(0) == '2'){
                if(act.charAt(0) == '1' && bag.item[1] > 0){
                    bag.used_item(1);
                    item.itemlist(1);
                    if( hp+item.hp <= maxhp){
                        hp = hp + item.hp;
                    }
                    else{
                        hp = maxhp;
                    }
                }
                if(act.charAt(0) == '2' && bag.item[2] > 0){
                    bag.used_item(2);
                    item.itemlist(2);
                    if( exp+item.exp < 100){
                        exp = exp + item.exp;
                    }
                    else{
                        exp = 100;
                        levelUp();
                    }
                }
            }
        }
        private  void levelUp(){
            if(exp >= 100){
                exp = 0;
                level = level + 1;
                maxhp = maxhp + 5 + (level/3);
                hp = maxhp;
                bag.slot_increate();
                System.out.println("LEVEL UP "+ level +"!! \n" );
            }
        }
        private  void gameOver(){
            String action;
            System.out.println("Game Over");
            System.out.println("Restart game(r) or Exit(e)?");
            action = scan.next();
            if(action.charAt(0) == 'r'){
                hp = 10;
                maxhp = 10;
                exp = 0;
                level = 1;
            }
            else{
                System.exit(0);
            }
        }
       
        
} 
