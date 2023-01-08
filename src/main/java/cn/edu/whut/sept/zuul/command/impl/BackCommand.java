/**
 * 返回命令
 */
package cn.edu.whut.sept.zuul.command.impl;

import cn.edu.whut.sept.zuul.Game;
import cn.edu.whut.sept.zuul.command.Command;
import cn.edu.whut.sept.zuul.command.ICommand;

public class BackCommand extends Command implements ICommand {
    @SuppressWarnings("unused")
    public BackCommand() {
        super();
    }

    /**
     * 执行该命令返回上次进入的房间，只能返回一次
     * @return 假
     */
    @SuppressWarnings("unused")
    @Override
    public boolean execute(Game game) {
        if(game.getLastRoom()!=null){
            game.setCurrentRoom(game.getLastRoom());
            game.setLastRoom(null);
            System.out.println(game.getCurrentRoom().getLongDescription());
        }else{
            System.out.println("Cannot go back..");
        }
        return false;
    }
}
