/**
 * items 命令
 */
package cn.edu.whut.sept.zuul.command.impl;

import cn.edu.whut.sept.zuul.Game;
import cn.edu.whut.sept.zuul.Item;
import cn.edu.whut.sept.zuul.command.Command;
import cn.edu.whut.sept.zuul.command.ICommand;

import java.util.List;

public class ItemsCommand extends Command implements ICommand {
    public ItemsCommand() {
        super();
    }

    /**
     * 执行该命令查看玩家物品栏
     * @param game
     * @return 假
     */
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
