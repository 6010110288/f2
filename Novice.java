import java.util.*;
public class Novice{    
    Scanner scan = new Scanner(System.in);
    Rand rand = new Rand();
    protected static int maxhp = 10;
    protected static int hp = 10;
    protected static int exp = 0;
    protected static int level = 1;
    protected static int atk = 10;
    protected static Bag bag = new Bag();
    protected static Item item = new Item();
    protected static String job = new String("Novice");
    protected static int money = 0;
        public Novice(){
        }
        public  void printStats(){
            System.out.println("CLASS: " + job + " HP: " + hp + " LEVEL: " + level + " EXP: " + exp + "/" + level*level  + "\n");
        }
        public  void attack() {
                exp = exp +( 100/level );
                System.out.println("Yor earn :" + exp + "exp!!\n");
                levelUp();
        }
        public void move(){
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
        public void inventery(){
                bag.info();
                use_item();        
        }
        private void use_item(){
            System.out.println("Select item No.(1/2) to use or Exit (other key)");
            Scanner scan = new Scanner(System.in);
            String act = scan.next();
            if(act.charAt(0) == '1' || act.charAt(0) == '2'){
                if(act.charAt(0) == '1' && bag.item[1] > 0){
                    bag.used_item(1);
                    item = new HP_Potion();
                    if( hp+item.hp <= maxhp){
                        hp = hp + item.hp;
                    }
                    else{
                        hp = maxhp;
                    }
                }
                if(act.charAt(0) == '2' && bag.item[2] > 0){
                    bag.used_item(2);
                    item = new EXP_Potion();
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
            if(exp >= Math.pow(level, 2)){
                exp = 0;
                level = level + 1;
                maxhp = maxhp + 5 + (level/3);
                hp = maxhp;
                atk += 1;
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
        public int damage(int damg){
            return hp = hp - damg;
        }

        public int hp(){
            return hp;
        }

        public int maxHp(){
            return maxhp;
        }

        public void earnMoney(int earnmoney){
            money = money + earnmoney;
        }

        public void dead(){
            gameOver();
        }
        public int level(){
            return level;
        }
        public int atk(){
            return atk;
        }
} 
