/**
 * take命令
 */
package cn.edu.whut.sept.zuul.command.impl;

import cn.edu.whut.sept.zuul.Game;
import cn.edu.whut.sept.zuul.Item;
import cn.edu.whut.sept.zuul.command.Command;
import cn.edu.whut.sept.zuul.command.ICommand;

import java.util.List;

public class TakeCommand extends Command implements ICommand {
    @SuppressWarnings("unused")
    public TakeCommand() {
        super();
    }

    /**
     * 允许玩家拿取物品
     */
    @SuppressWarnings("unused")
    @Override
    public boolean execute(Game game) {
        if(getSecondWord()==null){
            System.out.println("Take what?");
            return false;
        }
        List<Item> roomItemList = game.getCurrentRoom().getItemList();
        //遍历当前房间的物品列表查找指定物品
        for(Item item : roomItemList){
            //存在此物品,物品从房间转移到玩家物品栏
            if(item.getName().equals(getSecondWord())){
                //超重
                if(item.getWeight() + game.getPlayer().getWeight() > game.getPlayer().getMaxWeight()){
                    System.out.println("Cannot carry more..");
                }else{//未超重
                    game.getPlayer().getItem(item);
                    game.getCurrentRoom().removeItem(item);
                    System.out.println("You take the " + item.getName());
                }
                return false;
            }
        }
        System.out.println("There is no such item in the room..");
        return false;
    }
}
