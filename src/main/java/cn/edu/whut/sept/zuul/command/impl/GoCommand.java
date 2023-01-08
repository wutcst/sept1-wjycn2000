/**
 * 前往命令
 */
package cn.edu.whut.sept.zuul.command.impl;

import cn.edu.whut.sept.zuul.Constraint;
import cn.edu.whut.sept.zuul.Game;
import cn.edu.whut.sept.zuul.Portal;
import cn.edu.whut.sept.zuul.Room;
import cn.edu.whut.sept.zuul.command.Command;
import cn.edu.whut.sept.zuul.command.ICommand;

public class GoCommand extends Command implements ICommand {
    /**
     * 根据输入的第一个单词和第二个单词生成命令
     */
    public GoCommand() {
        super();
    }

    /**
     * 如果没有输入第二个单词则询问玩家去哪里；否则走该方向的门。如果没有门或者不允许进入系统给予提示。
     * @param game
     * @return 假
     */
    @Override
    public boolean execute(Game game) {
        if(!hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return false;
        }

        String direction = getSecondWord();

        // Try to leave current room.
        Room currentRoom = game.getCurrentRoom();
        Room nextRoom = currentRoom.getExit(direction);




        if (nextRoom == null) {
            System.out.println("There is no door!");
        }
        else {
            //检查约束
            if(!game.getConstraints().isEmpty()){
                for(Constraint constraint : game.getConstraints()){
                    if(constraint.getFrom().equals(currentRoom) && constraint.getTo().equals(nextRoom)){
                        if(nextRoom.getShortDescription().indexOf("coins")!=-1){
                            System.out.println("The door has not opened.");
                            return false;
                        }
                        else if(nextRoom.getShortDescription().indexOf("lake")!=-1){
                            System.out.println("need a boat..");
                            return false;
                        }else if(nextRoom.getShortDescription().indexOf("dark")!=-1){
                            System.out.println("It's too dark. You need light.");
                            return false;
                        }
                    }
                }
            }


            game.setLastRoom(currentRoom);


            for(Portal portal : game.getPortals()){
                if(portal.getTriggerRoom().equals(nextRoom)){
                    System.out.println("You entered a portal room.");
                    System.out.println("You are teleported..");
                    nextRoom = portal.getTargetRoom();
                    game.setLastRoom(null);
                    break;
                }
            }

            game.setCurrentRoom(nextRoom);
            game.getPlayer().setCurrentRoom(nextRoom);
            System.out.println(game.getCurrentRoom().getLongDescription());
        }
        return false;
    }

}
