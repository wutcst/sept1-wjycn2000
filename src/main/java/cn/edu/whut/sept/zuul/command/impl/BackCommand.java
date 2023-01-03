/**
 * 返回命令
 */
package cn.edu.whut.sept.zuul.command.impl;

import cn.edu.whut.sept.zuul.Game;
import cn.edu.whut.sept.zuul.command.Command;
import cn.edu.whut.sept.zuul.command.ICommand;

public class BackCommand extends Command implements ICommand {
    public BackCommand() {
        super();
    }

    /**
     * 执行该命令返回上次进入的房间，只能返回一次
     * @param game
     * @return 假
     */
    @Override
    public boolean excute(Game game) {
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
