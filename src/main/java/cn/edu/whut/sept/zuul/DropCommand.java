/**
 * Drop命令
 */
package cn.edu.whut.sept.zuul;

import java.util.List;

public class DropCommand extends Command implements ICommand{
    public DropCommand() {
        super();
    }

    /**
     * 执行该命令丢掉物品，如果没有说明丢掉什么则系统询问。玩家没有该物品系统给予提示。
     * @param game
     * @return 假
     */
    @Override
    public boolean excute(Game game) {
        if(getSecondWord()==null){
            System.out.println("Drop what?");
            return false;
        }

        List<Item> playerItemList = game.getPlayer().getItemList();
        for(Item item : playerItemList){
            if(item.getName().equals(getSecondWord())){
                game.getCurrentRoom().addItem(item);
                game.getPlayer().loseItem(item);
                System.out.println("You drop the " + item.getName());
                return false;
            }
        }
        System.out.println("There is no such item on you..");
        return false;
    }
}
