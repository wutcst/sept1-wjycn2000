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
    public LookCommand() {
        super();
    }

    /**
     * 执行该命令来查看房间内的物品信息
     * @param game
     * @return 假
     */
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
