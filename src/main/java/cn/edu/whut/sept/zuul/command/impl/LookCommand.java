/**
 * 查看命令
 */
package cn.edu.whut.sept.zuul.command.impl;

import cn.edu.whut.sept.zuul.Game;
import cn.edu.whut.sept.zuul.Item;
import cn.edu.whut.sept.zuul.Room;
import cn.edu.whut.sept.zuul.command.Command;
import cn.edu.whut.sept.zuul.command.ICommand;

import java.util.List;

public class LookCommand extends Command implements ICommand {
    @SuppressWarnings("unused")
    public LookCommand() {
        super();
    }

    /**
     * 执行该命令来查看房间内的物品信息
     * @return 假
     */
    @SuppressWarnings("unused")
    @Override
    public boolean execute(Game game) {
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
