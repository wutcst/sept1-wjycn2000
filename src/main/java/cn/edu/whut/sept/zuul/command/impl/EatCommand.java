/**
 * Eat命令
 */
package cn.edu.whut.sept.zuul.command.impl;

import cn.edu.whut.sept.zuul.Game;
import cn.edu.whut.sept.zuul.Item;
import cn.edu.whut.sept.zuul.command.Command;
import cn.edu.whut.sept.zuul.command.ICommand;

import java.util.List;

public class EatCommand extends Command implements ICommand {
    @SuppressWarnings("unused")
    public EatCommand() {
        super();
    }

    /**
     * 执行该命令吃掉物品
     * @return 假
     */
    @SuppressWarnings("unused")
    @Override
    public boolean execute(Game game) {
        if(getSecondWord()==null){
            System.out.println("eat what?");
            return false;
        }

        if(getSecondWord().equals("mushroom")){
            List<Item> itemList = game.getPlayer().getItemList();
            for(Item item : itemList){
                if(item.getName().equals("mushroom")){
                    game.getPlayer().setMaxWeight(game.getPlayer().getMaxWeight()+5.0f);
                    game.getPlayer().loseItem(item);
                    System.out.println("You eat the mushroom..");
                    System.out.println("You can carry " + game.getPlayer().getMaxWeight()+"kg now!");
                    return false;
                }
            }
            System.out.println("You do not have a mushroom..");
        }
        return false;
    }
}
