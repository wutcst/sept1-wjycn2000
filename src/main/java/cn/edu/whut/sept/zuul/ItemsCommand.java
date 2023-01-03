package cn.edu.whut.sept.zuul;

import java.util.List;

public class ItemsCommand extends Command implements ICommand{
    public ItemsCommand() {
        super();
    }

    @Override
    public boolean excute(Game game) {
        List<Item> itemList = game.getPlayer().getItemList();
        if(itemList.isEmpty()){
            System.out.println("You have nothing on you..");
            return false;
        }else{
            System.out.println("You have following items: ");
            for(Item item: itemList){
                System.out.println(item.getName() + "\t-" + item.getDescription() + "\t" + item.getWeight() + "kg");
            }
            System.out.println("You are carrying " + game.getPlayer().getWeight() +"kg");
        }
        return false;
    }
}
