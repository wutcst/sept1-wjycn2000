package cn.edu.whut.sept.zuul;

import java.util.List;

public class GoCommand extends Command implements ICommand{
    /**
     * 根据输入的第一个单词和第二个单词生成命令
     */
    public GoCommand() {
        super();
    }

    @Override
    public boolean excute(Game game) {
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
            System.out.println(game.getCurrentRoom().getLongDescription());
        }
        return false;
    }

}
