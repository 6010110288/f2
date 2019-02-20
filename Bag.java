import java.util.*;
public class Bag{
    int i = 20;
    int slot[][] = new int[i][2];
    int used_slot = 0;
    int item[] = new int[3];
    Item itemlist = new Item();

    private void initail(){
        for(int x = 0; x < i ; x++){
            slot[x][0] = 0;
            slot[x][1] = 0;
        }
        for(int x = 0; x < 3 ; x++){
            item[x]= 0;
        }
    }

    public void slot_increate(){
        i++ ;
        int increate_slot[][] = new int[i][2];
        for(int x = 0; x < i-1; x++ ){
            for(int y = 0; y < 2; y++ ){
                increate_slot[x][y] = slot[x][y];
                increate_slot[x+1][y] = 0;
            }
            
        } 
        slot = increate_slot; 
    }
    public void in_slot(int itemNO){
        int index = 0;
        int num = 2;
        
        while(num > 1){
            if(slot[index][0] == 1 && index < i+1){
                index++;
                used_slot = index + 1;
            }
            else{
                if(index == i){
                    System.out.println("Inventery is FULL!!");
                    break;
                }
                else{
                    slot[index][0] = 1;
                    slot[index][1] = itemNO;
                    item[itemNO]++;
                    used_slot = index + 1;
                    break;
                }
            }
        }
    }
    public void info(){
        System.out.println("Slot : " + used_slot + "/" + i);
        itemlist.itemlist(1);
        System.out.println("1." +  itemlist.name +": " + item[1] +" ea");
        itemlist.itemlist(2);
        System.out.println("2." +  itemlist.name +": " + item[2] +" ea");
    }
    public void find_item(int itemNO){
        itemlist.itemlist(itemNO);
        System.out.println("You Found a " + itemlist.name +". get it?(y/n)");
        Scanner scan = new Scanner(System.in);
        String act = scan.next();
        while(act.charAt(0) != 'y' || act.charAt(0) != 'n'){
            if(act.charAt(0) == 'y'){
                in_slot(itemNO);
                System.out.println("You got " + itemlist.name + "!!");
                break;
            }
            act = scan.next();
        }
    }
    public void used_item(int itemNO){
        item[itemNO]--;
        for(int x = 0;x < i;x++){
                slot[x][0] = 0;
                slot[x][1] = 0;
                used_slot = used_slot - 1;
                break;
        }
    }
}