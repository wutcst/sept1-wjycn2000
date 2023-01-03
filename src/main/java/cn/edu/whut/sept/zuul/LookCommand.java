package cn.edu.whut.sept.zuul;

import java.util.List;

public class LookCommand extends Command implements ICommand{
    public LookCommand() {
        super();
    }

    @Override
    public boolean excute(Game game) {
        Room currentRoom = game.getCurrentRoom();
        List<Item> itemList = currentRoom.getItemList();
        if(itemList.isEmpty()){
            System.out.println("You found nothing..");
            return false;
        }
        System.out.println("After a careful search, you found: ");
        for(Item item : itemList){
            System.out.println(item.getName() + "\t-"+item.getDescription() + "\t" + item.getWeight() + "kg");
        }
        return false;
    }
}
